package io.javapractice.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        /*ReactiveSources.intNumbersFluxWithException()
                .subscribe(number -> System.out.println(number),
                        throwable -> System.out.println(throwable.getMessage()));*/
        /*ReactiveSources.intNumbersFluxWithException()
                .doOnError(Throwable::getMessage)
                .subscribe(System.out::println);*/


        // Print values from intNumbersFluxWithException and continue on errors
        /*ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((throwable, o) -> {
                    System.out.println("There is an exception: " + throwable.getMessage());
                    System.out.println("object from ErrorContinue: " + o);
                }).subscribe(System.out::println);*/

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(throwable -> {
                    System.out.println(throwable.getMessage());
                    return Flux.just(-1, -2);
                })
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
