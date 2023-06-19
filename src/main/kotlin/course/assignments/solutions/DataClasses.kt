package course.assignments.solutions

data class Individual(val name: String, val age: Int)

fun main() {
    val person1 = Individual("John", 25)
    val person2 = Individual("Jane", 25)
    val person3 = person2
    println(person1 == person2)
    println(person2 == person3)
    println(person1.toString())
    println(person2.toString())

    val modifiedPerson1 = person1.copy(age = 30)
    val (name, age) = modifiedPerson1
    println("Name: $name, Age: $age")

    data class Individual2(val name: String, val age: Int) {
        var city: String = ""
    }

    val person4 = Individual2("John", 25).apply { city = "New York" }
    println(person4)
    val person5 = Individual2("Jane", 25).apply {
        city = "Los Angeles"
    }

    println(person4 == person5)
}
