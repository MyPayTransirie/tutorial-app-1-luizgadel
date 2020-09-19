package br.uea.mypay.tutoriais.demomylaundry.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.uea.mypay.tutoriais.demomylaundry.R

class ResumoPedidoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_resumo_pedido)
        setTitle(R.string.resumo_pedido)
    }
}