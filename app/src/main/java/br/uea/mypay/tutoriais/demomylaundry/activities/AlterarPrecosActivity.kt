package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.models.*
import kotlinx.android.synthetic.main.activity_tabela_precos.*

class AlterarPrecosActivity : AppCompatActivity() {
    var servicoListDatabase: ArrayList<Servico> = arrayListOf(
        TrocaPneu(0,"",20.0f),
        FuroSimples(0, "", 20.0f),
        TrocaValvula(0,   "", 10.0f),
        FuroVulcanizado(0, "",30.0f),
    )

    var servicoList: ArrayList<Servico> = arrayListOf<Servico>()

    lateinit var adapterTabelaPrecos: TabelaPrecosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela_precos)
        setTitle("Tabela de Preços")

        adapterTabelaPrecos = TabelaPrecosAdapter(this, servicoList)
        lvListaServicoPreco.adapter = adapterTabelaPrecos

        btSalvar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        setSpinner()
    }

    private fun setSpinner() {
        spnTipoGeral.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                when(position) {
                    1 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is FuroSimples })
                    2 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is FuroVulcanizado })
                    3 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is TrocaPneu })
                    4 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is TrocaValvula })
                    5 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is Recauchutagem })
                    6 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is Desamassamento })
                    7 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is Calibragem})
                }
                adapterTabelaPrecos.notifyDataSetChanged()
                adapterTabelaPrecos = TabelaPrecosAdapter(this@AlterarPrecosActivity, servicoList)
                lvListaServicoPreco.adapter = adapterTabelaPrecos

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
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
            spnTipoGeral.adapter = adapter
        }
    }
}