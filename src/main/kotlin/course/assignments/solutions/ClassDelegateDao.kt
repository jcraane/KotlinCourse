package course.assignments.solutions

import course.examples.delegates.Person
import course.examples.delegates.java.JpaPersonDao
import course.examples.delegates.java.PersonDao

fun main() {
    val dao = MyPersonDaoDelegation(MyPersonDaoDelegation(JpaPersonDao()))

    println(dao.getPerson(1))
    println(dao.getPersons())
    dao.getPerson(2)
}

class MyPersonDaoDelegation(private val personDao: PersonDao) : PersonDao by personDao {
    override fun getPerson(id: Int): Person {
        return personDao.getPerson(id) ?: throw IllegalArgumentException("Person not found")
    }
}
