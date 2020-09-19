package br.uea.mypay.tutoriais.demomylaundry.models

// data class ItemPedido(TODO...)

class Pedido(
    val listaServico: ArrayList<Servico>,
) {
    data class ItemPedido(val nome: String, val observacao: String, val preco: Float)
}