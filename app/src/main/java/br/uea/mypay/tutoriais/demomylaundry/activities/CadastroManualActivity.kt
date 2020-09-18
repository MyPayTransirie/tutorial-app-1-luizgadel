package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.activity_cadastro_manual.*

class CadastroManualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_manual)
        supportActionBar?.title = "Cadastro"
        supportActionBar?.subtitle = "Manual"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btCadastrarManual.setOnClickListener { confirmaAlteraValor() }
    }

    fun confirmaAlteraValor() {
        val alertDialog = AlertDialog.Builder(this@CadastroManualActivity).create()
        alertDialog.setTitle("Alterar Preço")
        alertDialog.setMessage("Deseja alterar a Tabela de Preços?")
        alertDialog.setButton(
            AlertDialog.BUTTON_NEUTRAL, "Sim"
        ) { dialog, which ->
            dialog.dismiss()
            startActivity(Intent(this, AlterarPrecosActivity::class.java))
            finish()
        }
        alertDialog.setButton(
            AlertDialog.BUTTON_NEGATIVE, "Não"
        ) { dialog, which ->
            dialog.dismiss()
            startActivity(Intent(this, AbrirCaixaActivity::class.java))
            finish()
        }
        alertDialog.show()
    }
}