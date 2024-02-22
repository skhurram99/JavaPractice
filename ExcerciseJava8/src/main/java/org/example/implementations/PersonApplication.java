package org.example.implementations;

import org.example.interfaces.CheckPerson;
import org.example.model.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
* Practice lambda expressions
* Refer  {@link https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html}
* */
public class PersonApplication {

    /**
     * Approach 1: Create Methods That Search for Members That Match One Characteristic
     * @param roaster
     * @param age
     */
    public void printPersonApproach1(List<Person> roaster, int age){
        for (Person p : roaster){
            if(p.getAge() >= age)
                System.out.println("p = " + p);
        }
    }

    /**
     * Approach 3: Specify Search Criteria Code in a Local Class
     * @param roaster
     * @param personChecker
     */
    public void printPersonApproach3(List<Person> roaster, PersonChecker personChecker){
        for (Person p : roaster){
            if(personChecker.test(p))
                System.out.println("p = " + p);
        }
    }

    /**
     * Approach 4: Specify Search Criteria Code in an Anonymous Class
     * @param roaster
     * @param personChecker
     */
    public void printPersonApproach4(List<Person> roaster, CheckPerson<Person> checkPerson){
        for (Person p : roaster){
            if(checkPerson.test(p))
                System.out.println("p = " + p);
        }
    }

    /**
     * Approach 6: Use Standard Functional Interfaces with Lambda Expressions
     * @param roaster
     * @param Predicate
     *
     * Instead of our interface, we can use standard functional interfaces
     * which are readily available in java library( java.util.function package )
     */
    public void printPersonApproach6(List<Person> roaster, Predicate<Person> checkPerson){
        for (Person p : roaster){
            if(checkPerson.test(p))
                System.out.println("p = " + p);
        }
    }

    /**
     * Approach 7:  Use Lambda Expressions Throughout Your Application
     * @param roaster
     * @param Predicate
     *
     * Instead of our interface, we can use standard functional interfaces
     * which are readily available in java library( java.util.function package )
     */
    public void printPersonApproach7(List<Person> roaster, Predicate<Person> checkPerson,
                                     Consumer<Person> block){
        for (Person p : roaster){
            if(checkPerson.test(p))
                block.accept(p);
        }
    }

    // Use @java.util.function.Function to get email address of the person
    // which matches the search criteria
    public void printPersonApproach7a(List<Person> roaster,
                                      Predicate<Person> checkPerson,
                                      Function<Person, String> func,
                                      Consumer<String> consumer){
        for (Person p : roaster){
            if(checkPerson.test(p)) {
                String data = func.apply(p);
                consumer.accept(data);
            }
        }
    }


    /**
     * Approach 8: Use Generics More Extensively
     * @param roaster
     * @param Predicate
     *
    The following is a generic version of it that accepts,
    as a parameter, a collection that contains elements of any data type
     */
    public <X, Y> void printPersonApproach8(Iterable<X> roaster,
                                      Predicate<X> checkPerson,
                                      Function<X, Y> func,
                                      Consumer<Y> consumer){
        for (X p : roaster){
            if(checkPerson.test(p)) {
                Y data = func.apply(p);
                consumer.accept(data);
            }
        }
    }

}
