package course.examples.functions

fun main() {
    val uppercase = "hello".myTransform { it.uppercase() } // Lambda expression
    println(uppercase)

    val hello: (String) -> Unit = {
        println("Hello, $it")
    }
    // "Henk".hello() // Does not compile since hello is not defined as a function with receiver
    hello("Henk") // pass in receiver
    hello.invoke("Henk") // invoke function

    // Function types with receiver
    val sayHello: String.() -> Unit = {
        println("Hello, $this")
    }
    "John".sayHello() // call directly on receiver
    sayHello("John") // pass in receiver
    sayHello.invoke("John") // invoke function
}

// Higher order function because it takes a function as a parameter, named 'operation'
private inline fun <T, R> T.myTransform(operation: (T) -> R): R {
    return operation(this)
}
