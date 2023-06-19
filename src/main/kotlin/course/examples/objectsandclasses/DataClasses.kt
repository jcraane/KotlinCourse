package course.examples.objectsandclasses

fun main() {
    data class Person(val name: String, val age: Int)

    val person1 = Person("John Doe", 30)
    val (name, age) = person1
    println("Name: $name, Age: $age")

    val person2 = Person("John Doe", 30)
    println(person1 == person2)
}
