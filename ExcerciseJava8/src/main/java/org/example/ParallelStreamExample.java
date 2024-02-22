package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args){
        Integer[] intArray = {1,4,2,5,3,9,6,7,8};
        Comparator<Integer> comparatorAscending = Integer::compare;
        Comparator<Integer> comparatorDescending = comparatorAscending.reversed();

        /**
         * Arrays.stream(intArray)
                .sorted(Comparator.reverseOrder()) // .sorted(comparatorDescending)
                .forEach(System.out::println);*/
        Arrays.sort(intArray, Comparator.reverseOrder());
        System.out.println("intArray : "+ Arrays.stream(intArray).toList());

        Arrays.stream(intArray)
                .parallel()
                .forEach(i -> System.out.print(" "+i));


    }
}
