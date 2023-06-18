package course.examples.controlflow

/**
 * This program demonstrates exception handling in Kotlin.
 */
fun main() {
    // Example of throwing an exception
    try {
        throwException()
    } catch (e: Exception) {
        println("Caught exception: ${e.message}")
        e.printStackTrace()
    }

    // Example of catching an exception
    try {
        someCode()
    } catch (e: SomeException) {
        println("Caught SomeException: ${e.message}")
    } finally {
        println("Finally block executed")
    }

    // Example of using try as an expression
    val a: Int? = try {
        parseInt("10")
    } catch (e: NumberFormatException) {
        null
    }
    println("Value of a: $a")

    // Example of using throw as part of Elvis expression
    val s = getName() ?: throw IllegalArgumentException("Name required")
    println("Name: $s")

    iReturnNothing()
//    println("Unreachable code")
//    TODO("Implement this code")
}

/**
 * Throws a simple exception with a message.
 */
fun throwException() {
    throw Exception("Hi There!")
}

/**
 * A custom exception class.
 */
class SomeException(message: String) : Exception(message)

/**
 * A function that throws a custom exception.
 */
fun someCode() {
    throw SomeException("Custom Exception")
}

/**
 * Parses a string to an integer.
 * @return The parsed integer value.
 * @throws NumberFormatException if the string cannot be parsed to an integer.
 */
fun parseInt(str: String): Int {
    return str.toInt()
}

/**
 * Returns the name or null if the name is not available.
 * @return The name value or null.
 */
fun getName(): String? {
    return null
}

fun iReturnNothing(): Nothing {
    throw Exception("I return nothing")
}

