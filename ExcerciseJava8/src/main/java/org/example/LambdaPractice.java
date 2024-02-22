package org.example;

import org.example.implementations.PersonApplication;
import org.example.model.Person;

import java.util.List;

public class LambdaPractice {
    public static void main(String[] args) {

        List<Person> roaster = Person.createRoaster();
        PersonApplication pApp = new PersonApplication();
        // Approach 1: Create Methods That Search for Members That Match One Characteristic
        //pApp.printPersonApproach1(roaster, 25);

        // Approach 3: Specify Search Criteria Code in a Local Class
        //pApp.printPersonApproach3(roaster, new PersonChecker());

        // Approach 4: Specify Search Criteria Code in an Anonymous Class
       /**
        *  pApp.printPersonApproach4(roaster, new CheckPerson<Person>() {
            @Override
            public boolean test(Person p) {
                return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
            }
        });*/

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        /**
         * pApp.printPersonApproach4(roaster, p -> {
            return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
        });*/


        //Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        /**
         * pApp.printPersonApproach6(roaster, p -> {
            return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
        });*/


        //Approach 7: Use Lambda Expressions Throughout Your Application
        /**
        pApp.printPersonApproach7(roaster, p -> {
            return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
        }, p -> {
            System.out.println(p.getName() +" "+ p.getAge());
        });*/

        // Use function to get email address of the person which matches the search criteria
        /**
        pApp.printPersonApproach7a(roaster,
                p -> {
                    return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
                },
                Person::getEmailAddress,
                System.out::println);
                */

        //Approach 8: Use Generics More Extensively
      /**
       *  pApp.printPersonApproach8(roaster,
                p -> {
                    return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;
                },
                Person::getEmailAddress,
                System.out::println);
       */


        //Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
        roaster.stream()
                .filter( p -> {return p.getAge()>=25 && p.getGender()==Person.Sex.MALE;} )
                .map(Person::getEmailAddress)
                .forEach(System.out::println);



    }




}