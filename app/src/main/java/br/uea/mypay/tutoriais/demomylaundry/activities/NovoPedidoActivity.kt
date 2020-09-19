package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.models.*
import kotlinx.android.synthetic.main.activity_novo_pedido.*
import kotlinx.android.synthetic.main.activity_novo_pedido.spnTipoGeral
import kotlinx.android.synthetic.main.activity_tabela_precos.*

class NovoPedidoActivity : AppCompatActivity() {
    var servicoListDB: ArrayList<Servico> = arrayListOf(
        TrocaPneu(0, "Aro 20", 55.90f),
        TrocaPneu(1, "Aro 14", 69.90f),
        TrocaPneu(2, "Aro 17", 75.0f),
        TrocaPneu(3, "Aro 18", 69.90f),
        TrocaPneu(4, "Aro 19", 72.90f),
        TrocaPneu(5, "Aro 21", 79.90f),
        FuroSimples(0, "Macarrão", 20.0f),
        FuroSimples(1, "Remendo", 30.0f),
        FuroSimples(2, "Plugue", 35.0f),
        FuroVulcanizado(0, "Vulcanização", 30.0f),
        TrocaValvula(0, "Troca de Válvula de Calibragem", 10.0f),
    )

    var servicoList: ArrayList<Servico> = arrayListOf<Servico>()

    lateinit var adapterTabelaPedido: TabelaPedidoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_pedido)
        setTitle(R.string.receber_pedido)

        adapterTabelaPedido = TabelaPedidoAdapter(this, servicoList)

        btFinalizarPedido.setOnClickListener {
            startActivity(Intent(this, ResumoPedidoActivity::class.java))
        }
        setSpinner()
    }

    private fun setSpinner() {
        spnTipoGeral.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(position) {
                    1 -> servicoList = ArrayList(servicoListDB.filter { it is FuroSimples })
                    2 -> servicoList = ArrayList(servicoListDB.filter { it is FuroVulcanizado })
                    3 -> servicoList = ArrayList(servicoListDB.filter { it is TrocaPneu })
                    4 -> servicoList = ArrayList(servicoListDB.filter { it is TrocaValvula })
                    5 -> servicoList = ArrayList(servicoListDB.filter { it is Recauchutagem })
                    6 -> servicoList = ArrayList(servicoListDB.filter { it is Desamassamento })
                    7 -> servicoList = ArrayList(servicoListDB.filter { it is Calibragem })
                }
                adapterTabelaPedido.notifyDataSetChanged()
                adapterTabelaPedido = TabelaPedidoAdapter(this@NovoPedidoActivity, servicoList)
                lvServicosDisponiveis.adapter = adapterTabelaPedido
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.tipos_servico,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnTipoGeral.adapter = adapter
        }
    }
}