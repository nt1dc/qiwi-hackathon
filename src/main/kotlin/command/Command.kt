package command

abstract class Command(
    val name: String,
    val argsMap: Map<String, String>,
){
    abstract fun execute()
}
