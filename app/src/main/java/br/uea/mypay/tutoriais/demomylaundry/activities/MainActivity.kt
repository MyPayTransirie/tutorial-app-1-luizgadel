package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Serviços")

        btSair.setOnClickListener {
            alertCaixaFechado {
                startActivity(Intent(this, InicializacaoActivity::class.java))
                finish()
            }
        }

        btFecharCaixa.setOnClickListener {
            startActivity(Intent(this, FecharCaixaActivity::class.java))
        }
    }

    private fun alertCaixaFechado(callback: () -> Unit) {
        val alertDialog = AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle(getString(R.string.caixa))
        alertDialog.setMessage(getString(R.string.caixa_fechado))
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, "OK"
        ) { dialog, _ ->
            dialog.dismiss()
            callback()
        }
        alertDialog.show()
    }
}