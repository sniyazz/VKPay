val moneyTransfer: Int = 400000

val paymentMethod: String = "VKPay" // VKPay, visaAndMir, mastercardAndMaestro
val priviewTrasfers: Int = 0
var summTranfers = priviewTrasfers + moneyTransfer
var comission: Int = 0
var text: String = " "

fun main() {
    println(transfer(paymentMethod, priviewTrasfers, moneyTransfer))

}

fun transfer(paymentMethod: String, priviewTrasfers: Int, moneyTransfer: Int): String {
    if (paymentMethod == "VKPay" && summTranfers > 0 && summTranfers <= 4000000) {
        text = "Сумма перевода через сервис VK Pay составляет $moneyTransfer копеек"
    } else if (paymentMethod == "visaAndMir" && summTranfers > 0 && summTranfers <= 60000000) {
        comission = (moneyTransfer * 0.0075).toInt()
        if (comission < 3500) {
            comission = 3500
        }
        text = """Сумма перевода по карте VISA или МИР составляет $moneyTransfer копеек
            |Комиссия составила $comission копеек
        """.trimMargin()
    } else if (paymentMethod == "mastercardAndMaestro" && summTranfers > 0 && summTranfers <= 60000000) {
        if (summTranfers > 0 && summTranfers <= 7500000) {
            comission = 0
        } else comission = (moneyTransfer * 0.006 + 2000).toInt()
        text = """Сумма перевода по карте Mastercard или Maestro составляет $moneyTransfer копеек
            |Комиссия составила $comission копеек
        """.trimMargin()
    } else text = "Вы превысили лимит по переводу!"
    return text
}


