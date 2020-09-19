package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.models.Servico
import kotlinx.android.synthetic.main.item_pedido_geral.view.*

class TabelaPedidoAdapter(
    private val ctx: Context,
    private val listaServicos: List<Servico>
): BaseAdapter() {
    companion object {
        data class ViewHolder(val view: View) {
            val tvObservacao = view.tvObservacao
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
        holder.tvObservacao.text = servico.observacao
        holder.tvPreco.text = servico.preco.toString()
        holder.btIncluir.setOnClickListener {
            Log.println(Log.INFO, "Meu nome é btIncluir", "alo")
        }
        return row
    }
}