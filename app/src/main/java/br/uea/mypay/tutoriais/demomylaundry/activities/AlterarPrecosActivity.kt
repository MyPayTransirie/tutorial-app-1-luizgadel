package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.TabelaPrecosAdapter
import br.uea.mypay.tutoriais.demomylaundry.models.*
import kotlinx.android.synthetic.main.activity_tabela_precos.*

class AlterarPrecosActivity : AppCompatActivity() {

    var servicoListDatabase: List<Servico> = arrayListOf(
        Servico(0, TipoServico.FURO, 20.0f, "Furo simples"),
        Servico(1, TipoServico.FURO,30.0f, "Vulcanização"),
        Servico(0,TipoServico.TROCA_PNEU, 20.0f, "Troca de Pneu"),
        Servico(0, TipoServico.TROCA_VALVULA, 10.0f, "Troca da válvula de calibragem"),
    )

    var servicoList: MutableList<Servico> = arrayListOf<Servico>()

    lateinit var adapterTabelaPrecos: TabelaPrecosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela_precos)
        setTitle(R.string.tabela_precos)

        adapterTabelaPrecos = TabelaPrecosAdapter(this, servicoList)
        tabelaPrecos_lvServico.adapter = adapterTabelaPrecos

        tabelaPrecos_btSalvar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        setSpinner()
    }

    private fun setSpinner() {
        tabelaPrecos_spn.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when(position) {
                    1 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.FURO })
                    2 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.TROCA_PNEU })
                    3 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.TROCA_VALVULA })
                    4 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.RECAUCHUTAGEM })
                    5 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.DESAMASSAMENTO })
                    6 -> servicoList = ArrayList(servicoListDatabase.filter { it.tipoServico == TipoServico.CALIBRAGEM })
                }
                adapterTabelaPrecos.notifyDataSetChanged()
                adapterTabelaPrecos = TabelaPrecosAdapter(this@AlterarPrecosActivity, servicoList)
                tabelaPrecos_lvServico.adapter = adapterTabelaPrecos
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Cria um ArrayAdapter usando um string array e um spinner layout padrão
        ArrayAdapter.createFromResource(
            this,
            R.array.tipos_servico,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Especifica o layout a ser usado para a lista de opções
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Aplica o adapter ao spinner
            tabelaPrecos_spn.adapter = adapter
        }
    }

    private fun updateDatabase() {

    }
}