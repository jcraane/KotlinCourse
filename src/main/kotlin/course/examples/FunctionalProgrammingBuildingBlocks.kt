package course.examples

fun main() {
    // Higher-order function
    fun repeat(times: Int, action: (Int) -> Unit) {
        for (i in 0 until times) {
            action(i)
        }
    }

// Lambda expression
    repeat(3) { i ->
        println("Hello, world $i")
    }
// Output:
// Hello, world 0
// Hello, world 1
// Hello, world 2

    // Function type
    val sayHello: (String) -> Unit = fun(name: String) {
        println("Hello, $name")
    }

// Collection operations
    val numbers = listOf(1, 2, 3, 4, 5)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    val doubledNumbers = numbers.map { it * 2 }
    println(evenNumbers) // Output: [2, 4]
    println(doubledNumbers) // Output: [2, 4, 6, 8, 10]

}
