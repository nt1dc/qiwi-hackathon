import command.CommandService
import java.lang.Exception
import java.util.*


fun main() {

    val commandService = CommandService()
    val scanner = Scanner(System.`in`)
    while (true) {
        try {
            val nextLine = scanner.nextLine()
            if (nextLine == "exit") return
            val extractCommand = commandService.extractCommand(nextLine)
            commandService.executeCommand(extractCommand)
        } catch (e: Exception) {
            System.err.println(e.message)
        }

    }
}







