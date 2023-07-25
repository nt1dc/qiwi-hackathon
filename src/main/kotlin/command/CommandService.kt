package command

class CommandService {
    fun extractCommand(string: String): Command {
        val split = string.split(" ")
        val argsMap = split.subList(1, split.size).map {
            val split1 = it.split("=")
            return@map split1[0] to split1[1]
        }.toList().associate { it.first to it.second }
        return Command(split[0], argsMap)
    }

}