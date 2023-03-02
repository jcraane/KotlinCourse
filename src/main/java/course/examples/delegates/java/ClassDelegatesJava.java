package course.examples.delegates.java;

import course.examples.delegates.Person;

public class ClassDelegatesJava {
    public static void main(String[] args) {
        MyPersonDao myPersonDao = new MyPersonDao(new JpaPersonDao());

        Person person = myPersonDao.getPerson(1);
        System.out.println(person.getName());

        System.out.println(myPersonDao.getPersons());

        myPersonDao.getPerson(2);
    }
}
