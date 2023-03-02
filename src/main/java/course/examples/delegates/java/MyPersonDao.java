package course.examples.delegates.java;

import course.examples.delegates.Person;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyPersonDao implements PersonDao{

    private PersonDao delegate;

    public MyPersonDao(PersonDao delegate) {
        this.delegate = delegate;
    }

    @Nullable
    @NotNull
    @Override
    public Person getPerson(int id) {
        Person person = delegate.getPerson(id);
        if (person == null) {
            throw new RuntimeException("Person not found");
        }

        return person;
    }

    @NotNull
    @Override
    public List<Person> getPersons() {
        return delegate.getPersons();
    }

    @Override
    public void insertPerson(@NotNull Person person) {
        delegate.insertPerson(person);
    }

    @Override
    public void updatePerson(@NotNull Person person) {
        delegate.updatePerson(person);
    }

    @Override
    public void deletePerson(@NotNull Person person) {
        delegate.deletePerson(person);
    }
}
