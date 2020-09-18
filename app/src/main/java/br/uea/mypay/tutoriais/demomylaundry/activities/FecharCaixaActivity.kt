package br.uea.mypay.tutoriais.demomylaundry.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.activity_fechar_caixa.*

class FecharCaixaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fechar_caixa)
        title = getString(R.string.fechamento)

        btImprimir.setOnClickListener {
            avisaImprimindo()
        }

        btVoltar.setOnClickListener {
            finish()
        }

        btSair.setOnClickListener {
            finish()
        }
    }

    fun avisaImprimindo() {
        val alertDialog = AlertDialog.Builder(this@FecharCaixaActivity).create()
        alertDialog.setTitle(getString(R.string.title_imprimindo))
        alertDialog.setMessage(getString(R.string.msg_impressao_iniciada))
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, "OK"
        ) { dialog, which ->
            dialog.dismiss()
            finish()
        }
        alertDialog.show()
    }
}