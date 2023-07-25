import api.CentralBankApi
import command.CommandService
import command.CursValuesCommand
import java.util.*


fun main() {
    val centralBankApi = CentralBankApi()
    val commandService = CommandService()
    val scanner = Scanner(System.`in`)

    val nextLine = scanner.nextLine()
    val extractCommand = commandService.extractCommand(nextLine)
    val cursValuesCommand = CursValuesCommand(extractCommand)
    val loadValCurs = centralBankApi.loadValCurs(cursValuesCommand.date)
    cursValuesCommand.execute(loadValCurs)
}







