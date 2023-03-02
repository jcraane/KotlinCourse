package course.examples.functions

fun main() {
    fun printMessage(message: String, action: (String) -> Unit) {
        println("Message: $message")
        action(message)
    }

    printMessage("Hello, World!") { msg ->
        println("The message is: $msg")
    }
}
