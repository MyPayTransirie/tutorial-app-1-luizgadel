package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.activity_ler_web.*

class CadastroWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ler_web)
        supportActionBar?.title = "Cadastro"
        supportActionBar?.subtitle = "Arquivo Web"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btLerConfigWeb.setOnClickListener {
            alertBaixado {
                startActivity(Intent(this, AbrirCaixaActivity::class.java))
            }
        }
    }

    private fun alertBaixado(callback: () -> Unit) {
        val alertDialog = AlertDialog.Builder(this@CadastroWebActivity).create()
        alertDialog.setTitle(getString(R.string.arquivo_baixado_title))
        alertDialog.setMessage(getString(R.string.arquivo_baixado_msg))
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, "OK"
        ) { dialog, _ ->
            dialog.dismiss()
            callback()
            finish()
        }
        alertDialog.show()
    }
}