package io.javapractice.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumbersFlux()
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.out.println(throwable.getMessage()),
                        () -> System.out.println(" Flux completed"));

        // Get the value from the Mono into an integer variable
        ReactiveSources.intNumberMono()
                .subscribe(integer -> System.out.println(integer),
                        throwable -> System.out.println(throwable),
                        () -> System.out.println("Mono completed"));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
