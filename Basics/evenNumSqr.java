package Basics;

import java.util.List;
import java.util.Arrays;

public class evenNumSqr {
    // This program calculates the square of even numbers from 1 to 10
    public static void main(String[] args) {
        List<Integer> evenSquares = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println("Squares of even numbers from 1 to 10: " + evenSquares);
    }
}
