package course.assignments.solutions

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private val repository = FileRepository("data.properties")

fun main() {
    val person = Person()
    person.firstName = "John"
    person.lastName = "Doe"
    println("Firstname: ${person.firstName}, Lastname: ${person.lastName}")
}

private class Person {
    var firstName: String? by FileRepositoryDelegate(repository)
    var lastName: String? by FileRepositoryDelegate(repository)
}

private class FileRepository(val fileName: String) {
    private val properties = Properties()

    init {
        File(fileName).createNewFile()
        val file = FileInputStream(fileName)
        properties.load(file)
        file.close()
    }

    fun get(key: String): String? {
        return properties.getProperty(key)
    }

    fun set(key: String, value: String) {
        properties.setProperty(key, value)
        save()
    }

    fun remove(key: String) {
        properties.remove(key)
        save()
    }

    private fun save() {
        val file = FileOutputStream(fileName)
        properties.store(file, null)
        file.close()
    }
}

private class FileRepositoryDelegate(
    private val fileRepository: FileRepository,
) : ReadWriteProperty<Any?, String?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? {
        return fileRepository.get(property.name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        value?.let { fileRepository.set(property.name, it) }
    }
}
