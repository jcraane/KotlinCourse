package course.examples.delegates.java;

import course.examples.delegates.Person;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public final class JpaPersonDao implements PersonDao{

    @Nullable
    @Override
    public Person getPerson(int id) {
        if (id == 1) {
            return new Person("John Doe", 25);
        } else {
            return null;
        }
    }

    @NotNull
    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John Doe", 25));
        persons.add(new Person("Jane Doe", 25));
        return persons;
    }

    @Override
    public void insertPerson(@NotNull Person person) {
        System.out.println("Inserting person: " + person.getName());
    }

    @Override
    public void updatePerson(@NotNull Person person) {
        System.out.println("Updating person: " + person.getName());
    }

    @Override
    public void deletePerson(@NotNull Person person) {
        System.out.println("Deleting person: " + person.getName());
    }
}
