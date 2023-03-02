package course.examples.delegates

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun main() {
    class MyReadOnlyProperty : ReadOnlyProperty<Any?, String> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "Hello, world!"
        }
    }

    class MyDelegate {
        operator fun provideDelegate(
            thisRef: Any?,
            prop: KProperty<*>
        ): ReadOnlyProperty<Any?, String> {
            println("Delegate initialized for ${prop.name}")
            return MyReadOnlyProperty()
        }
    }

    class MyClass {
        val myProperty: String by MyDelegate()
    }


    val obj = MyClass()
    println(obj.myProperty)
}
