package command

import api.ValCurs
import exception.ValuteNotFoundException
import java.text.SimpleDateFormat
import java.util.Date

class CursValuesCommand(command: Command) : Command(command.name, command.argsMap) {
    val date: Date = SimpleDateFormat("yyyy-MM-dd").parse(argsMap["--date"]!!)
    val code: String = argsMap["--code"]!!
    fun execute(valuteCurs: ValCurs) {
        val valute = valuteCurs.valutes.find { it.charCode == code }
            ?: throw ValuteNotFoundException("valute ${code} not found")
        println("${valute.charCode} (${valute.name}): ${valute.value}")
    }
}