package br.uea.mypay.tutoriais.demomylaundry.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.Toast
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.activities.NovoPedidoActivity
import br.uea.mypay.tutoriais.demomylaundry.models.ItemPedido
import br.uea.mypay.tutoriais.demomylaundry.models.Pedido
import br.uea.mypay.tutoriais.demomylaundry.models.Servico
import kotlinx.android.synthetic.main.item_pedido_geral.view.*
import java.lang.Exception
import java.lang.NumberFormatException

class TabelaPedidoAdapter(
    private val ctx: Context,
    private val listaServicos: List<Servico>,
): BaseAdapter() {

    companion object {
        data class ViewHolder(val view: View) {
            val tvDescricao = view.tvDescricao
            val tvPreco = view.tvPreco
            val btIncluir = view.btIncluir
        }
    }

    override fun getCount(): Int = listaServicos.size

    override fun getItem(position: Int): Servico = listaServicos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val servico = listaServicos[position]
        val holder: ViewHolder
        val row: View
        if (convertView == null) {
            row = LayoutInflater.from(ctx).inflate(R.layout.item_pedido_geral, parent, false)
            holder = ViewHolder(row)
            row.tag = holder
        } else {
            row = convertView
            holder = convertView.tag as ViewHolder
        }
        holder.tvDescricao.text = servico.descricao
        holder.tvPreco.text = "R$ " + servico.preco.toString()
        holder.btIncluir.setOnClickListener {
            var qtdServico = 1
            val builder: AlertDialog.Builder = AlertDialog.Builder(ctx)
            builder.setTitle("Quantidade")
            builder.setMessage("Digite a quantidade para esse serviço")

            val input = EditText(ctx)
            input.setText(qtdServico.toString())
            input.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL

            builder.setView(input)
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                try {
                    qtdServico = input.text.toString().toInt()
                    val item = ItemPedido(servico, "", qtdServico)
                    NovoPedidoActivity.infoPedido.listaItens.add(item)
                    NovoPedidoActivity.numIncluidos++
                } catch (e: Exception) {
                    Toast.makeText(ctx, "Informe um valor", Toast.LENGTH_SHORT).show()
                }
                notifyDataSetChanged()
            })
            builder.setNegativeButton(
                "Cancelar",
                DialogInterface.OnClickListener { dialog, _ -> dialog.cancel() }
            )
            builder.show()
        }
        return row
    }
}