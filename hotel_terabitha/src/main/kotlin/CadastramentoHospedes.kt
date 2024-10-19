package Hotel


import kotlin.system.exitProcess

fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        ""
    )

    while (true) {
        println("""Cadastro de Hóspedes
            Selecione uma opção:
            1. Cadastrar
            2. Pesquisar
            3. Sair""")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarHospede(listaHospedes: MutableList<String>) {

    var totalHospedagem = 0
    var gratuidade = 0
    var meia = 0

    while (true) {
        println("Cadastro de Hóspedes.\nPor favor, informe o nome do Hóspede (ou digite PARE para encerrar):")
        val novoHospede = readln()

        if (novoHospede.equals("PARE", ignoreCase = true)) {
            // Exibe o valor total e quantidade de gratuidades e meias
            println("$novoHospede, o valor total das hospedagens é: R$$totalHospedagem; $gratuidade gratuidade(s); $meia meia(s)")
            break
        }

        println("Qual o valor padrão da diária? ")
        val valorDiaria = readln().toIntOrNull() ?: 0

        println("Informe sua idade:")
        val idadeHospede = readln().toIntOrNull() ?: 0

        when {
            idadeHospede < 6 -> {
                println("$novoHospede cadastrado(a) com sucesso. $novoHospede possui gratuidade.")
                gratuidade++
            }
            idadeHospede > 60 -> {
                println("$novoHospede cadastrado(a) com sucesso. $novoHospede paga meia.")
                meia++
                totalHospedagem += valorDiaria / 2
            }
            else -> {
                println("$novoHospede cadastrado(a) com sucesso!")
                totalHospedagem += valorDiaria
            }
        }

        listaHospedes.add(novoHospede)
        println("Lista de Hóspedes atuais: $listaHospedes")
    }
}



fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    val nomeHospede = readln()

    if (listaHospedes.any { it.contains(nomeHospede, ignoreCase = true) }) {
        println("\nEncontramos a(s) hóspede(s):")
        listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }
            .forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        // uppercase fará o que for digitado ser convertido para maiúsculo por exemplpo x -> X
        "S" -> {
            println("Ok tchau, tenha um ótimo dia.")
            exitProcess(0)
        }
        "N" -> {
            println("Ok, voltando ao início.")
            cadastrarHospedes()
        }
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
}