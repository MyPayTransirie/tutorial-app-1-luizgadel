package br.uea.mypay.tutoriais.demomylaundry.models

// abstract = não é possível instanciar
abstract class Servico(
    val id: Int,
    var nome: String,
    var observacao: String,
    var preco: Float
)

// furo simples

class FuroSimples(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(
    id,
    nome = "Furo Simples", // <<--- configura nome aqui, mas virá do banco no futuro
    observacao, preco
) {
}

class FuroVulcanizado(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Furo Vulcanizado", observacao, preco)

class TrocaPneu(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Troca de Pneu", observacao, preco)

class Desamassamento(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Desamassamento de roda de ferro", observacao, preco)

class Recauchutagem(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Recauchutagem", observacao, preco)

class TrocaValvula(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Troca de válvula de calibragem", observacao, preco)

class Calibragem(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Calibragem", observacao, preco)

// -----------------------------------------------
// nome completo
// enum class Genero { MASCULINO, FEMININO }

// nome abreviado
enum class Genero(val abreviacao: String) {
    MASCULINO("M"),
    FEMININO("F");

    override fun toString(): String = abreviacao
}