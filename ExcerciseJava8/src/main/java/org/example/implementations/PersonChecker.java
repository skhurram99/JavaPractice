package org.example.implementations;

import org.example.interfaces.CheckPerson;
import org.example.model.Person;

public class PersonChecker implements CheckPerson<Person> {

    @Override
    public boolean test(Person person) {
        return person.getAge() >= 25 && person.getGender() == Person.Sex.MALE;
    }
}
