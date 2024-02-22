package org.example;

import org.example.model.Person;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
{@link https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html}
 */
public class MethodReferenceExample {


    public static void main(String... args){
        // MethodReferenceExample.sortUsingComparatorInterface();
        // MethodReferenceExample.sortUsingLambda();
        // MethodReferenceExample.sortUsingComparable();
        MethodReferenceExample aNew = new MethodReferenceExample();
        aNew.sortUsingExternalComparator();

    }

    /*
    * sort Using comparator interface
    * */
    public static void sortUsingComparatorInterface(){
        List<Person> roaster = Person.createRoaster();
        Comparator<Person> comparatorByAge = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };


        Collections.sort(roaster, comparatorByAge);
        System.out.println("roaster = " + roaster);
    }


    /*
     * sort Using lambda interface
     * */
    public static void sortUsingLambda(){
        List<Person> roaster = Person.createRoaster();
        Comparator<Person> comparatorLambda = (o1, o2) -> {return o1.getAge() - o2.getAge();};


        Collections.sort(roaster, comparatorLambda);
        System.out.println("roaster = " + roaster);
    }


    /*
     * Utilize the comparable interface implemented fpr Person to sort the list
     * */
    public static void sortUsingComparable(){
        List<Person> roaster = Person.createRoaster();
        Collections.sort(roaster);
        System.out.println("roaster = " + roaster);
    }

    /*
     * Utilize the comparable interface implemented fpr Person to sort the list
     * */
    public  void sortUsingExternalComparator(){
        List<Person> roaster = Person.createRoaster();
        ComparatorPerson comparatorPerson = new ComparatorPerson();
        Collections.sort(roaster, comparatorPerson :: compareByAge);
        System.out.println("roaster = " + roaster);
        Integer
    }

    class ComparatorPerson{
        public int compareByAge(Person p1, Person p2){
            return p1.getAge().compareTo(p2.getAge());
        }

        public int compareByName(Person p1, Person p2){
            return p1.getName().compareTo(p2.getName());
        }
    }


}
