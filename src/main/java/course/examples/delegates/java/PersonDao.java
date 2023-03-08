package course.examples.delegates.java;

import course.examples.delegates.Person;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface PersonDao {
    @Nullable
    Person getPerson(int id);
    List<Person> getPersons();
    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}
