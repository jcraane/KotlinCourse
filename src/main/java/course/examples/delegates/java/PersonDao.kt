package course.examples.delegates.java

import course.examples.delegates.Person
import org.jetbrains.annotations.Nullable

interface PersonDao {
    @Nullable
    fun getPerson(id: Int): Person
    fun getPersons(): List<Person>
    fun insertPerson(person: Person)
    fun updatePerson(person: Person)
    fun deletePerson(person: Person)
}
