package br.uea.mypay.tutoriais.demomylaundry.activities

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.ItemPedidoAdapter
import kotlinx.android.synthetic.main.actvity_resumo_pedido.*

class ResumoPedidoActivity: AppCompatActivity() {
    val listaItemsPedido = NovoPedidoActivity.infoPedido.listaItens
    val numPedido = NovoPedidoActivity.infoPedido.id
    var totalPreco: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_resumo_pedido)
        setTitle(R.string.resumo_pedido)

        resumoPedido_rv.layoutManager = LinearLayoutManager(this)
        resumoPedido_rv.adapter = ItemPedidoAdapter(this, listaItemsPedido)
        resumoPedido_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        resumoPedido_tvNumPedido.text = "Pedido #$numPedido"
        resumoPedido_tvTotal.text = calculaTotal().toString()
    }

    private fun calculaTotal(): Float {
        listaItemsPedido.forEach {
            totalPreco += it.servico.preco*it.quantidade
        }
        return totalPreco
    }

    /*override fun onStop() {
        super.onStop()

    }*/
}