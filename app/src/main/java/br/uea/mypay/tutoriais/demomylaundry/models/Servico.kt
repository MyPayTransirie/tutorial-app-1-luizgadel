package br.uea.mypay.tutoriais.demomylaundry.models

import br.uea.mypay.tutoriais.demomylaundry.R

// abstract = não é possível instanciar
class Servico(
    val id: Int,
    val tipoServico: TipoServico,
    var preco: Float,
    var descricao: String
)

enum class TipoServico(val descricao: String) {
    FURO("Furo"),
    TROCA_PNEU("Troca de Pneu"),
    DESAMASSAMENTO("Desamassamento da roda de ferro"),
    RECAUCHUTAGEM("Recauchutagem"),
    TROCA_VALVULA("Troca de válvula de calibragem"),
    CALIBRAGEM("Calibragem")
}

// -----------------------------------------------
// nome completo
// enum class Genero { MASCULINO, FEMININO }

// nome abreviado
enum class Genero(val abreviacao: String) {
    MASCULINO("M"),
    FEMININO("F");

    override fun toString(): String = abreviacao
}