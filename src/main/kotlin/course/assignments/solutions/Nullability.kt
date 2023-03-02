package course.assignments.solutions

fun main() {
    var name: String? = "John Doe"
    println(name)
    name = null
    println(name)
    val length = name?.length
    println(length)
    val displayName = name ?: "Unknown"
    println(displayName)
}
