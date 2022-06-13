val moneyTransfer: Int = 1400000

val paymentMethod: String = "VKPay" // VKPay, visaAndMir, mastercardAndMaestro
val priviewTrasfers: Int = 0
var summTranfers = priviewTrasfers + moneyTransfer

fun main() {
    var comssion: Int = transfer(paymentMethod, moneyTransfer).toInt()
    var text: String = when {
        comssion == -1 -> "Вы превысили разовый или месячный лимит"
        comssion == -2 -> "Нет такого вида перевода"
        else -> """Сумма вашего перевода состаляет $moneyTransfer копеек
        |Комиссия за перевод составляет $comssion копеек
    """.trimMargin()
    }
    println(text)
}

fun transfer(paymentMethod: String, moneyTransfer: Int): Number {
    val comission = when (paymentMethod) {
        "VKPay" -> when {
            summTranfers < 4000000 && moneyTransfer < 1500000 -> 0
            else -> -1
        }
        "visaAndMir" -> when {
            summTranfers < 60000000 && moneyTransfer < 15000000 -> when {
                moneyTransfer * 0.0075 < 3500 -> 3500
                else -> moneyTransfer * 0.075
            }
            else -> -1
        }
        "mastercardAndMaestro" -> when {
            summTranfers < 60000000 && moneyTransfer < 15000000 -> when {
                summTranfers < 7500000 -> 0
                else -> moneyTransfer * 0.06 + 2000
            }
            else -> -1
        }
        else -> -2
    }
    return comission
}
