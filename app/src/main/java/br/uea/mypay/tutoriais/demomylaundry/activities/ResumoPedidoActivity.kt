package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.ItemPedidoAdapter
import br.uea.mypay.tutoriais.demomylaundry.models.Pedido
import com.google.gson.Gson
import kotlinx.android.synthetic.main.actvity_resumo_pedido.*

class ResumoPedidoActivity: AppCompatActivity() {
    val listaItemsPedido = NovoPedidoActivity.listaItens
    val numPedido = NovoPedidoActivity.id
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

        resumoPedido_btConcluir.setOnClickListener {
            val pedido = Pedido(listaItemsPedido, numPedido)

            val ggson = Gson()
            val pedidoJson = ggson.toJson(pedido)

            val pedidosPreferences = getSharedPreferences("pedidos", Context.MODE_PRIVATE)
            val prefsEdit = pedidosPreferences.edit()
            prefsEdit.putInt("proxId", numPedido+1)
            prefsEdit.putString("pedido$numPedido", pedidoJson)
            prefsEdit.apply()

            Toast.makeText(this, "O pedido #$numPedido foi anotado e pago!", Toast.LENGTH_LONG)

            NovoPedidoActivity.clearLista()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
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