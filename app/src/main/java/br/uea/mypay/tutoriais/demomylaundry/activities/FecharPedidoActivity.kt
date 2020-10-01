package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.ItemPedidoAdapter
import br.uea.mypay.tutoriais.demomylaundry.models.ItemPedido
import br.uea.mypay.tutoriais.demomylaundry.models.Pedido
import br.uea.mypay.tutoriais.demomylaundry.models.Servico
import br.uea.mypay.tutoriais.demomylaundry.models.TipoServico
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fechar_pedido.*
import java.lang.Exception

class FecharPedidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fechar_pedido)

        val pedidosPreference = getSharedPreferences("database", Context.MODE_PRIVATE)
        val pedidoJson = pedidosPreference.getString("pedido2", "")
        try {
            if (pedidoJson != "") {
                val ggson = Gson()
                val pedido = ggson.fromJson(pedidoJson, Pedido::class.java)
                Toast.makeText(applicationContext, "$pedidoJson", Toast.LENGTH_SHORT).show()

                fecharPedido_rv.layoutManager = LinearLayoutManager(this)
                fecharPedido_rv.adapter = ItemPedidoAdapter(this, pedido.listaItens)
                fecharPedido_rv.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
                fecharPedido_tvTitulo.text = "Pedido ${pedido.numeroPedido}"
            }
        } catch (e: Exception) {
            val editor = pedidosPreference.edit()
            editor.putString("pedido2", "")
        }
    }

    override fun onStop() {
        super.onStop()

        val databasePreferences = getSharedPreferences("database", Context.MODE_PRIVATE)
        val pedidoantigoStr = databasePreferences.getString("pedido2", "")
        if (pedidoantigoStr == "") {
            // instancia de servicos
            val servicoFurar = Servico(15, TipoServico.FURO, 10f, "Remendo")
            val servicoTrocaPneu = Servico(10, TipoServico.TROCA_PNEU, 10f, "Aro 17")
            val servicoCalibragem = Servico(5, TipoServico.CALIBRAGEM, 10f, "")

            //compor lista de itens, instanciando-os
            val listaItens = listOf(
                ItemPedido(servicoCalibragem, "com cuidado!", 1),
                ItemPedido(servicoTrocaPneu, "", 2),
                ItemPedido(servicoFurar, "", 3)
            )

            //compor pedido
            val pedido = Pedido(listaItens, 53)

            val ggson = Gson()
            val pedidoJson = ggson.toJson(pedido)
            val pedidosPrefEditor = databasePreferences.edit()
            pedidosPrefEditor.putString("pedido2", pedidoJson).apply()
        }
    }
}