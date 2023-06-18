package course.examples.delegates

import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

fun main() {
    class Person(val map: Map<String, Any?>) {
        var name: String by observable("John Doe") { _, _, newValue ->
            println("Name changed to $newValue")
        }

        val expensiveToCreate by lazy {
            println("Creating expensive object")
            42
        }

        // vetoable example
        var age: Int by vetoable(0) { _, _, newValue ->
            newValue >= 0
        }

        val city: String by map
        val street: String by map
    }

    // construct person
    val person = Person(mapOf(
        "city" to "Amsterdam",
        "street" to "Kerkstraat"
    ))

    // observe name
    person.name = "Jane Doe"
    println(person.expensiveToCreate)

    // observe age
    person.age = -1
    println(person.age)
    person.age = 10
    println(person.age)

    println(person.city)
    println(person.street)
}
