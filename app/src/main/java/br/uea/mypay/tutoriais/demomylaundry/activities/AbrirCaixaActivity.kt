package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.activity_abrir_caixa.*

class AbrirCaixaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abrir_caixa)
        setTitle("Abrir Caixa")

        btAbrirCaixa.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}