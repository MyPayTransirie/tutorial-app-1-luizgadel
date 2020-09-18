package br.uea.mypay.tutoriais.demomylaundry.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.uea.mypay.tutoriais.demomylaundry.R
import kotlinx.android.synthetic.main.cadastro_main.*

class InicializacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicializacao)
        btAlterarPreco.setOnClickListener {
            val alterarPrecoIntent = Intent(this, AlterarPrecosActivity::class.java)
            startActivityForResult(alterarPrecoIntent, 1)
        }
        btAbrirCaixa.setOnClickListener {
            startActivity(Intent(this, AbrirCaixaActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                finish()
            }
        }
    }
}