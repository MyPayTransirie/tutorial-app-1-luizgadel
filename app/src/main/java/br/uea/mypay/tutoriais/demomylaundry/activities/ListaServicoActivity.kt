package br.uea.mypay.tutoriais.demomylaundry.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.adapters.ServicoAdapter
import br.uea.mypay.tutoriais.demomylaundry.models.Servico
import br.uea.mypay.tutoriais.demomylaundry.models.TipoServico
import kotlinx.android.synthetic.main.activity_lista_servico.*

class ListaServicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_servico)

        val listaServico = listOf<Servico>(
            Servico(0, TipoServico.FURO, 10f, "engomar"),
            Servico(0, TipoServico.FURO, 10f, "passar"),
            Servico(0, TipoServico.FURO, 10f, "lavar")
        )

//        val listaServicoString = listaServico.map{it -> "(${it.tipoServico}) ${it.descricao}"}

        preencheServicoAdapter(listaServico)
    }

    private fun preencheServicoAdapter(listaServico: List<Servico>) {
        listaServico_lv.adapter = ServicoAdapter(this, listaServico)
    }

    private fun preencheComArrayAdapter(listaServicoString: List<String>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            listaServicoString
        )
        listaServico_lv.adapter = adapter

        listaServico_lv.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(applicationContext, "Servico $position - ${listaServicoString[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}