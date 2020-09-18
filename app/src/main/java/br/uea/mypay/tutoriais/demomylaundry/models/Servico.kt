package br.uea.mypay.tutoriais.demomylaundry.models

// abstract = não é possível instanciar
abstract class Servico(
    val id: Int,
    var nome: String,
    var observacao: String,
    var preco: Float
)

// lavagem por peso

class LavagemSimplesKg(
    id: Int,
    preco: Float,
    kilos: Int, // <<--- específico
    observacao: String
) : Servico(
    id,
    nome = "Lavagem Simples", // <<--- configura nome aqui, mas virá do banco no futuro
    observacao, preco
) {
}

class LavagemEspecial(
    id: Int,
    var peca: Peca, // <<--- específico
    preco: Float,
    observacao: String
) : Servico(id, nome = "(${peca.genero}) Camisa", observacao, preco)

class Engomar(
    id: Int,
    observacao: String,
    preco: Float
) : Servico(id, nome = "Engomar", observacao, preco)

// -----------------------------------------------
// nome completo
// enum class Genero { MASCULINO, FEMININO }

// nome abreviado
enum class Genero(val abreviacao: String) {
    MASCULINO("M"),
    FEMININO("F");

    override fun toString(): String = abreviacao
}

enum class PecaTipo { Camisa, Vestido, Saia, Bermuda }
enum class PecaSubTipo { Social, Esporte, Longo, Curto }

class Peca(
    var id: Int,
    var genero: Genero,
    var tipoPeca: PecaTipo,
    var pecaSubTipo: PecaSubTipo
)