package course.assignments.solutions

fun main() {
    val numbers = (1..10).toList()
    val evenNumbers = numbers.filter { it % 2 == 0 }
    val doubledNumbers = evenNumbers.map { it * 2 }
    val sum = doubledNumbers.reduce { acc, i -> acc + i }
    val sortedNumbers = numbers.sortedBy { it }

    println(evenNumbers) // Output: [2, 4, 6, 8, 10]
    println(doubledNumbers) // Output: [4, 8, 12, 16, 20]
    println(sum) // Output: 60
    println(sortedNumbers) // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
}
