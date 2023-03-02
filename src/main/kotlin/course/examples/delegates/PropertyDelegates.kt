package course.examples.delegates

import kotlin.properties.Delegates.observable

fun main() {
    val classWithPropertyDelegation = ClassWithPropertyDelegation()
    classWithPropertyDelegation.name = "John"
    classWithPropertyDelegation.name = "Jane"
}

private class ClassWithPropertyDelegation{
    var name: String by observable("No name") { _, _, newValue ->
        println("Name changed to $newValue")
    }
}
