package command

import api.CentralBankApi
import exception.ValuteNotFoundException
import java.text.SimpleDateFormat
import java.util.*

class CursValuesCommand(name: String, argsMap: Map<String, String>) : Command(name, argsMap) {
    val date: Date = SimpleDateFormat("yyyy-MM-dd")
        .parse(argsMap["date"] ?: throw IllegalArgumentException("--date not present"))
    val code: String = argsMap["code"] ?: throw IllegalArgumentException("--code not present")


    override fun execute(){
        val centralBankApi = CentralBankApi.getInstance()
        val valuteCurs = centralBankApi.loadValCurs(this.date)
        val valute = valuteCurs.valutes.find { it.charCode == code }
            ?: throw ValuteNotFoundException("valute $code not found")
        val resString = "${valute.charCode} (${valute.name}): ${valute.value}"
        println(resString)
    }
}