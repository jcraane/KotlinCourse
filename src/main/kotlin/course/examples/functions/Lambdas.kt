package course.examples.functions

fun main() {
    fun execute(times: Int, action: (Int) -> Unit) {
        action(times)
    }

    // Lambda expression
    execute(times = 3, action = { invocationCount ->
        println("Hello, world $invocationCount")
    })

    // Lambda moved out of parentheses and use implicit parameter name 'it'
    execute(times = 3) {
        println("Hello, world $it")
    }
}
