package org.example;

import org.example.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class AggregateExample {
    public static void main(String[] args) {
        final List<Person> roaster = Person.createRoaster();
        final OptionalDouble average = roaster
                .stream()
                .filter(person -> person.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average();

        System.out.println("average = " + average);
        System.out.println("----------------------");

        // Aggregate reduce operation
       Integer totalAgeReduce = roaster
                .stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);  // same as .reduce(0, (a,b) -> a+b);
        System.out.println("totalAgeReduce = " + totalAgeReduce);


        // Aggregate collect operation.
        // groupingBy(Function)
        // The following example groups members of the collection roster by gender:
        System.out.println("----------------------");
        System.out.println("Aggregate collect operation");
        List<Person> roaster1 = Person.createRoaster();
        roaster1
                .stream()
                .collect(Collectors.groupingBy(Person::getAge))
                .forEach((o, personList) -> {
                    System.out.println("0 = " + o);
                    System.out.println("people list = " + personList);
                });

        // Aggregate collect operation.
        // groupingBy(Function, Collector)
        // The following example retrieves the names of each member in the collection roster and groups them by gender:
        System.out.println("----------------------");
        System.out.println("Aggregate collect operation using Collectors.mapping");
        roaster1
                .stream()
                        .collect(Collectors.groupingBy(Person::getGender,
                                Collectors.mapping(Person::getName, Collectors.toList())))
                .forEach((sex, names) ->
                {
                    System.out.println("Gender: "+sex+ "\n" +"Names: "+names);
                });


        // Aggregate collect operation.
        // groupingBy(Function, Collector)
        // The following example retrieves the total age of members of each gender:
        System.out.println("----------------------");
        System.out.println("Aggregate collect operation using Collectors.reducing");
        roaster1
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.reducing(
                                0,
                                Person::getAge,
                                (a, b) -> (a+b))))
                .forEach((sex, integer) -> {
                    System.out.println("Gender = " + sex);
                    System.out.println("totalAge = " + integer);

                });


        // Aggregate collect operation.
        // groupingBy(Function, Collector)
        // The following example retrieves the average age of members of each gender:
        System.out.println("----------------------");
        System.out.println("Aggregate collect operation using Collectors.averagingInt");
        roaster1
                .stream()
                .collect(Collectors.groupingBy(Person::getGender,
                        Collectors.averagingInt(
                                Person::getAge
                               )))
                .forEach((sex, averageAge) -> {
                    System.out.println("Gender = " + sex);
                    System.out.println("averageAge = " + averageAge);

                });




    }



}
