package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.cadastro_main.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_main)
        btAlterarPreco.setOnClickListener {
            startActivity(Intent(applicationContext, CadastroWebActivity::class.java))
        }
        btAbrirCaixa.setOnClickListener {
            startActivity(Intent(applicationContext, CadastroManualActivity::class.java))
        }
    }
}