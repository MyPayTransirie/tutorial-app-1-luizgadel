package br.uea.mypay.tutoriais.demomylaundry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import br.uea.mypay.tutoriais.demomylaundry.R
import br.uea.mypay.tutoriais.demomylaundry.models.Servico
import kotlinx.android.synthetic.main.item_servico.view.*

class ServicoAdapter(val context: Context, val listaServico: List<Servico>): BaseAdapter() {
    override fun getCount() = listaServico.size

    override fun getItemId(position: Int): Long {
        return listaServico[position].id.toLong()
    }

    override fun getItem(position: Int): Any {
        return listaServico[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView != null) {
            view = convertView
        } else {
            view = LayoutInflater.from(context).inflate(
                R.layout.item_servico,
                parent,
                false
            )
        }
        val textView_id = view.tvId
        val textView_descricao = view.tvDescricao
        val textView_preco = view.tvPreco
        val textView_botao = view.bt

        val servico = listaServico[position]
        textView_id.text = servico.id.toString()
        textView_descricao.text = servico.descricao
        textView_preco.text = servico.preco.toString()
        textView_botao.setOnClickListener {
            Toast.makeText(context, "Servico #$position - ${listaServico[position].descricao}", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}