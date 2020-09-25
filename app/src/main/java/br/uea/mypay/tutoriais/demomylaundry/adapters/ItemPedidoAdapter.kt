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
    ): ItemPedidoAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_item_pedido, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemPedidoAdapter.ViewHolder, position: Int) {
        val itemPedido = listaItens[position]
        holder.nomeServico?.text = itemPedido.servico.descricao
        holder.quantidadeServico?.text = itemPedido.quantidade.toString()
    }

    override fun getItemCount(): Int = listaItens.size

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val nomeServico = item.itemPedido_tvNomeServico
        val quantidadeServico = item.itemPedido_tvQtdServico
    }
}
