package Hotel

var usuario: String = ""
var senha: Int = 2678
var nome_hotel: String = "Hotel do Curtis"
var teste: String = "Digite a sua senha:"
var lista_de_quartos = mutableListOf(
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
    "livre",
)

fun main() {
    inicio()
}

fun inicio() {
    teste = "Digite a sua senha:"

    println("Qual o nome do senhor(a)?")
    usuario = readln()
    senha()
}

fun senha() {
    println(teste)
    val senha2 = readln().toIntOrNull()

    if (senha2 == senha) {
        println("")
        println("Bem-vindo ao $nome_hotel, $usuario")
        println("")
        println("Escolha uma opção:")
        println(" 1 - Cadastrar Quartos")
        println(" 2 - Cadastrar Hóspedes")
        println(" 3 - Abastecimento de Automóveis")
        println(" 4 - EventosHotel")
        println(" 5 - Sair do Hotel")

        val escolha = readln().toIntOrNull()
        when (escolha) {
            1 -> cadastrarQuartos()
            2 -> cadastrarHospedes()
            3 -> abastecimentoDeAutomoveis()
            4 -> eventos()
            5 -> sairDoHotel()
            else -> erro()
        }
    } else {
        println("Senha Incorreta")
        teste = "Digite a sua senha novamente:"
        senha()
    }
}

fun cadastrarQuartos() {
    println("Qual o valor padrão da diária?")
    val valorDiaria = readln().toDoubleOrNull()
    while (valorDiaria != 55.0) {
        println("Valor invalido")
        return cadastrarQuartos()
    }

    println("Quantas diarias serão necessárias?")
    val estadia = readln().toInt()

    val valor_final = valorDiaria * estadia
    println("A quantidade de $estadia estadias vai dar um total de R$ $valor_final")

    var num = 1
    println("Aqui estão os quartos disponíveis:")
    println("")
    for (i in lista_de_quartos) {
        println("O quarto $num está: $i")
        num++
    }
    println("")
    println("Escolha um dos quartos:")
    val escolha = readln().toInt()


    if (escolha in 1..20) {
        if (lista_de_quartos[escolha - 1] == "livre") {
            println("$usuario, você confirma a hospedagem para $estadia dias no quarto $escolha por R$ $valor_final? (S/N)")
            val confirma = readln().lowercase()

            if (confirma == "s") {
                lista_de_quartos[escolha - 1] = "ocupado"
                println("Reserva efetuada!")
                inicio()
            } else {
                println("Reserva cancelada, voltando ao menu inicial.")
                inicio()
            }
        } else {
            println("Quarto indisponível")
            cadastrarQuartos()
        }
    }
}


fun abastecimentoDeAutomoveis() {
    println("Abastecimento de Automóveis em andamento...")
    inicio()
}

fun erro() {
    println("Por favor, informe um número entre 1 e 4.")
    inicio()
}

fun sairDoHotel() {
    println("Você deseja sair? (1 - Sim / 2 - Não)")
    val confirma = readln().toIntOrNull()
    when (confirma) {
        1 -> sair2()
        2 -> inicio()
        else -> {
            println("Opção inválida.")
            sairDoHotel()
        }
    }
}

fun sair2() {
    println("Muito obrigado e até logo, $usuario!")
    inicio()
}