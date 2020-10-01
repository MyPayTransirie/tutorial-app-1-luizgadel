package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.TabelaPedidoAdapter
import br.uea.mypay.tutoriais.demomylaundry.models.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_novo_pedido.*

class NovoPedidoActivity : AppCompatActivity() {

    var servicoListDB: ArrayList<Servico> = arrayListOf(
        Servico(0, TipoServico.FURO, 35.0f, "Plugues"),
        Servico(1, TipoServico.FURO, 30.0f, "Remendos"),
        Servico(2, TipoServico.FURO, 20.0f, "Macarrãos"),
        Servico(3, TipoServico.FURO, 30.0f, "Vulcanizações"),

        Servico(0, TipoServico.TROCA_PNEU, 69.90f, "Aro 14"),
        Servico(1, TipoServico.TROCA_PNEU, 75.0f, "Aro 17"),
        Servico(2, TipoServico.TROCA_PNEU, 55.90f, "Aro 20"),
        Servico(3, TipoServico.TROCA_PNEU, 69.90f, "Aro 18"),
        Servico(4, TipoServico.TROCA_PNEU, 72.90f, "Aro 19"),
        Servico(5, TipoServico.TROCA_PNEU, 79.90f, "Aro 21"),

        Servico(0, TipoServico.TROCA_VALVULA, 10.0f, "Trocas de Válvula de Calibragem")
    )

    var servicoList: ArrayList<Servico> = arrayListOf<Servico>()

    lateinit var adapterTabelaPedido: TabelaPedidoAdapter

    companion object {
        var numIncluidos = 0
    }

    object infoPedido {
        lateinit var listaItens: MutableList<ItemPedido>
        var id: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_pedido)
        setTitle(R.string.receber_pedido)

        adapterTabelaPedido = TabelaPedidoAdapter(this, servicoList)
        novoPedido_lv.adapter = adapterTabelaPedido

        novoPedido_btFinalizarPedido.setOnClickListener {
            startActivity(Intent(this, ResumoPedidoActivity::class.java))
            finish()
        }
        setSpinner()

        infoPedido.listaItens = mutableListOf()
    }

    private fun setSpinner() {
        novoPedido_spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    1 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.FURO })
                    2 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.TROCA_PNEU })
                    3 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.TROCA_VALVULA })
                    4 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.RECAUCHUTAGEM })
                    5 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.DESAMASSAMENTO })
                    6 -> servicoList = ArrayList(servicoListDB.filter { it.tipoServico == TipoServico.CALIBRAGEM })
                }
                adapterTabelaPedido.notifyDataSetChanged()
                adapterTabelaPedido = TabelaPedidoAdapter(this@NovoPedidoActivity, servicoList)
                novoPedido_lv.adapter = adapterTabelaPedido

                novoPedido_tvNumIncluidos.text = numIncluidos.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.tipos_servico,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            novoPedido_spn.adapter = adapter
        }
    }
}