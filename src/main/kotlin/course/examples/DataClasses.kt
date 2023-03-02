package course.examples

fun main() {
    data class Person(val name: String, val age: Int)

    val person1 = Person("John Doe", 30)
    val person2 = Person("Jane Doe", 25)
    val person3 = Person("Jane Doe", 25)

    println(person1 == person2) // Output: false
    println(person2 == person3) // Output: true
    println(person1.toString()) // Output: Person(name=John Doe, age=30)
    println(person1.copy(age = 35)) // Output: Person(name=John Doe, age=35)

    val (name, age) = person1
    println(name) // Output: John Doe

    data class Person2(val name: String, val age: Int) {
        constructor(name: String) : this(name, 0)
        var city: String = ""
    }

    val person4 = Person2("John Doe", 30).apply { city = "Amsterdam" }
    val person5 = Person2("John Doe", 30).apply { city = "Oss" }
    println(person3) // Output: Person2(name=John Doe, age=30)

    println(person4 == person5) // Output: true
}
