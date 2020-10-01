package br.uea.mypay.tutoriais.demomylaundry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.models.ItemPedido
import kotlinx.android.synthetic.main.item_item_pedido.view.*

class ItemPedidoAdapter(
    private val context: Context,
    private val listaItens: List<ItemPedido>) :
    RecyclerView.Adapter<ItemPedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_item_pedido, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPedido = listaItens[position]
        val qtd = itemPedido.quantidade.toString()
        val desc = itemPedido.servico.descricao
        val tipo = itemPedido.servico.tipoServico.toString()
        val preco = "R$ " + itemPedido.servico.preco.toString()

        holder.quantidadeServico?.text = qtd
        if (desc.length > 2) {
            holder.nomeServico?.text = desc
            holder.tipoServico?.text = tipo
        } else {
            holder.nomeServico?.text = tipo
            holder.tipoServico?.text = ""
        }
        holder.precoServico?.text = preco
    }

    override fun getItemCount(): Int = listaItens.size

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val quantidadeServico = item.itemPedido_tvQtdServico
        val nomeServico = item.itemPedido_tvNomeServico
        val tipoServico = item.itemPedido_tvTipoServico
        val precoServico = item.itemPedido_tvPrecoParcial
    }
}
