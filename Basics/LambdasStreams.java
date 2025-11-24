package Basics;

import java.util.Arrays;
import java.util.List;

public class LambdasStreams {
    // Lambda expressions are a feature of Java 8 that allow you to write
    // anonymous functions in a more concise way. They are often used in
    // functional programming and can be passed as arguments to methods.
    // Streams are a new abstraction introduced in Java 8 that allow you to
    // process sequences of elements in a functional style.

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(n -> System.out.print(n+" ")); // Using lambda expression to print each element
        // Example of using lambda expressions and streams
        String[] names = {"Alice", "Bob", "Charlie", "David"};
        Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }
}
