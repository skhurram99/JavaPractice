package io.javapractice.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        Stream<Integer> integerStream = StreamSources.intNumbersStream();
        //integerStream.forEach(System.out::println);
        System.out.println("-------------------");

        // Print numbers from intNumbersStream that are less than 5
        /*integerStream
                .filter(integer -> integer < 5 ? true : false)
                .forEach(System.out::println);*/

        // Print the second and third numbers in intNumbersStream that's greater than 5

       /* List<Integer> intArray = integerStream.toList();
        IntStream.range(0, (intArray.size() - 1))
                .filter(index -> (index == 2 || index == 3) && (intArray.get(index) > 5) ? true : false)
                .mapToObj(value -> intArray.get(value))
                .forEach(System.out::println);*/

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
       /* Integer number = integerStream
                .filter(integer -> integer > 51)
                .findFirst()
                .orElse(-1);
        System.out.println(number);*/


        // Print first names of all users in userStream
        //
        /*Stream<User> userStream = StreamSources.userStream();
        userStream
                .map(user -> user.getFirstName())
                .forEach(System.out::println);*/


        // Print first names in userStream for users that have IDs from number stream

        /*List<Integer> integerList = integerStream.collect(Collectors.toList());

        Stream<User> userStream = StreamSources.userStream();
        userStream
                .filter(user -> integerList.contains(user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));
*/

        integerStream
                .flatMap(id ->
                        StreamSources.userStream()
                                .filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);


    }

}
