package command

class CommandService {
    fun extractCommand(string: String): Command {
        if (string.isEmpty()) throw IllegalArgumentException("empty command")
        val split = string.trim().split(" ")
        val commandName = split[0]
        val argsMap = split.subList(1, split.size).map {
            val arg = it.split("=")
            val argName = arg[0].removePrefix("--")
            val argVal = arg[1]
            argName to argVal
        }.toList().associate { it.first to it.second }
        return Command(commandName, argsMap)
    }

}