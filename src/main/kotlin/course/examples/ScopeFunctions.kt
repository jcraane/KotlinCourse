package course.examples

private data class Person(val name: String, val age: Int) {
    var street: String = ""
    var city: String = ""
}

fun main() {
    val p: Person? = null

    // Use let to perform operations on an object and return the result. Use ? for safe call
    val nameLet = p?.name?.let {
        it.uppercase()
    }
    println(nameLet)

    // Use apply when you need to perform operations on an object, and return the original object for further processing.
    val person = Person("John Doe", 30).apply {
        street = "Kerkstraat"
        city = "Amsterdam"
    }
    println(person)

    // Use run to perform operations on an object and return the result. Use ? for safe call
    val nameRun = p?.name?.run {
        uppercase()
    }
    println(nameRun)

    // Use with when you need to perform operations on an object, and you want to avoid repeating the object name in the lambda expression.
    val nameWith = with(Person("John Doe", 30)) {
        println("Name: $name")
        println("Age: $age")
        println("Street: $street")
        println("City: $city")
    }
    println(nameWith)

    // Use also when you need to perform operations on an object, and return the original object, in a more concise syntax.
    val personAlso = Person("John Doe", 30).also {
        it.street = "Kerkstraat"
        it.city = "Amsterdam"
    }
    println(personAlso)

    doSomething("Henk")
}

private fun doSomething(name: String) {
    val person = Person("Jan", 30)
    with(person) {
        val names = name + name
        println(names)
    }
}
