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
        LavagemSimplesKg(0, 2.0f, 1, ""),
        //-------------------------
        LavagemEspecial(1,
            Peca(0, Genero.MASCULINO, PecaTipo.Camisa, PecaSubTipo.Esporte),
            5.0f,
            ""),
        //-------------------------
        LavagemEspecial(1,
        Peca(0, Genero.FEMININO, PecaTipo.Camisa, PecaSubTipo.Social),
        7.0f,
        ""),
        //---------------
        Engomar(1, "", 15.0f),
        LavagemSimplesKg(0, 2.0f, 1, ""),
        //-------------------------
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
                    1 -> {
                        servicoList =
                            ArrayList(servicoListDatabase.filter { it is LavagemSimplesKg })
                    }
                    2 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is LavagemEspecial })
                    3 ->
                        servicoList = ArrayList(servicoListDatabase.filter { it is Engomar })
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