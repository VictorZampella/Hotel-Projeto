package Hotel

var pessoas_eventos = 0
var dia_evento = ""
var hora_evento = 0
var empresa = ""
var garçom = 0
var horario_eventos1 = 0

fun eventos() {
    println("Quantas pessoas estarão no evento?")
    pessoas_eventos = readln().toInt()

    if (pessoas_eventos in 0..350) {
        if (pessoas_eventos < 150) {
            println("Use o auditório Laranja")
            horario_Eventos()
        } else if (pessoas_eventos in 151..220) {
            println("Use o auditório Laranja (inclua mais ${pessoas_eventos - 150} cadeiras)")
            horario_Eventos()
        } else if (pessoas_eventos > 220) {
            println("Use o auditório Colorado")
            horario_Eventos()
        }
    } else if (pessoas_eventos < 0) {
        println("Valor inválido!")
        println("Digite novamente:")
        eventos()
    } else {
        println("Número de convidados superior à capacidade máxima")
        eventos()
    }
}

fun horario_Eventos() {
    println("Agora vamos ver a agenda do evento\n")

    println("Qual o dia do seu evento?")
    dia_evento = readln().lowercase()
    if (dia_evento == "sábado" || dia_evento == "domingo") {
        println("Qual a hora do seu evento?")
        hora_evento = readln().toInt()
        if (hora_evento !in 7..15) {
            println("Horário fora de funcionamento, Auditório indisponível\n")
            println("Segunda a Sexta das 7hs às 23hs \nSábados e Domingos apenas das 7hs às 15hs \n")
            horario_Eventos()
        } else {
            println("Qual o nome da empresa?")
            empresa = readln()
            println("Auditório reservado para $empresa no $dia_evento às $hora_evento hs.\n\n")
        }
    } else {
        println("Qual a hora do seu evento?")
        hora_evento = readln().toInt()
        while (hora_evento !in 7..23) {
            println("Horário fora de funcionamento, Auditório indisponível")
            println("Segunda a Sexta das 7hs às 23hs \nSábados e Domingos apenas das 7hs às 15hs \n")
            println("Qual a hora do seu evento?")
            hora_evento = readln().toInt()
        }

        println("Qual o nome da empresa?")
        empresa = readln()
        println("Auditório reservado para $empresa no $dia_evento às $hora_evento hs.\n")
    }
    garcom()
}

fun garcom() {
    println("Qual a duração do evento em horas?")
    horario_eventos1 = readln().toInt()
    val calc = horario_eventos1 / 2
    val contagem_garcom = pessoas_eventos / 12
    garçom = contagem_garcom + calc
    println("São necessários $garçom garçons")
    val custoGarcons = garçom * 10.5
    println("E o custo é R$ $custoGarcons")
    println("Agora vamos calcular o custo do buffet do hotel para o evento.")
    buffet(custoGarcons)
}

fun buffet(custoGarcons: Double) {
    val cafe_litros = pessoas_eventos * 0.2
    val agua_litros = pessoas_eventos * 0.5
    val contagem_salgado = pessoas_eventos * 7

    val custoCafe = cafe_litros * 0.8
    val custoAgua = agua_litros * 0.4
    val custoSalgados = contagem_salgado / 100.0 * 34

    val custoTotalBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de $cafe_litros litros de café, $agua_litros litros de água, $contagem_salgado salgados.")
    println("Custo total com comida do evento: R$ ${"%.2f".format(custoTotalBuffet)}")
    confirm_eventos(pessoas_eventos, custoGarcons, custoTotalBuffet)
}

fun confirm_eventos(pessoas_eventos: Int, custoGarcons: Double, custoTotalBuffet: Double) {
    val custoTotalEvento = custoGarcons + custoTotalBuffet

    println("\nResumo do Evento:")
    println("Nome da Empresa: $empresa")
    println("Data: $dia_evento, $horario_eventos1 hs.")
    println("Duração do evento: $hora_evento horas.")
    println("Quantidade de garçons: $garçom")
    println("Quantidade de Convidados: $pessoas_eventos")

    println("\nCusto dos garçons: R$ ${"%.2f".format(custoGarcons)}")
    println("Custo do Buffet: R$ ${"%.2f".format(custoTotalBuffet)}")
    println("\nValor total do Evento: R$ ${"%.2f".format(custoTotalEvento)}")

    println("\nGostaria de efetuar a reserva? (S/N): ")
    val resposta = readLine()?.lowercase() ?: ""
    if (resposta == "s") {
        println("Reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}