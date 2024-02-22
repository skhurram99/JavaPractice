package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person>{ //


    @Override
    public int compareTo(Person p) {
         return this.name.compareTo(p.getName());
        //return this.age.compareTo(p.getAge());
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;

    Integer age;
    LocalDate birthday;

    public Sex getGender() {
        return gender;
    }

    Sex gender;
    String emailAddress;

    public static List<Person> createRoaster(){
        Person p1 = new Person();
        p1.setAge(74);
        p1.setName("emp1");
        p1.setEmailAddress("emp1@gmail.com");
        p1.setGender(Sex.FEMALE);

        Person p2 = new Person();
        p2.setAge(55);
        p2.setName("emp2");
        p2.setEmailAddress("emp2@gmail.com");
        p2.setGender(Person.Sex.MALE);

        Person p3 = new Person();
        p3.setAge(40);
        p3.setName("emp3");
        p3.setEmailAddress("emp3@gmail.com");
        p3.setGender(Person.Sex.MALE);

        Person p4 = new Person();
        p4.setAge(23);
        p4.setName("emp4");
        p4.setEmailAddress("emp4@gmail.com");
        p4.setGender(Sex.MALE);

        Person p5 = new Person();
        p5.setAge(34);
        p5.setName("emp5");
        p5.setEmailAddress("emp4@gmail.com");
        p5.setGender(Person.Sex.FEMALE);

        Person p6 = new Person();
        p6.setAge(44);
        p6.setName("emp6");
        p6.setEmailAddress("emp6@gmail.com");
        p6.setGender(Person.Sex.FEMALE);

        return Arrays.asList(p1, p2, p3, p4, p5, p6);
    }

}
