package course.examples.collections

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    // Obtaining an explicit iterator to print each number
    val numbersIterator = numbers.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    // Using for loop to print each number
    for (item in numbers) {
        println(item)
    }

    // Using forEach to execute a block of code for each item
    numbers.forEach {
        println(it)
    }
}
