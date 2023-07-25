package command

import java.text.SimpleDateFormat
import java.util.Date

class CursValuesCommand(command: Command) : Command(command.name, command.argsMap) {
    val date: Date = SimpleDateFormat("yyyy-MM-dd").parse(argsMap["--date"]!!)
    val code: String = argsMap["--code"]!!

}