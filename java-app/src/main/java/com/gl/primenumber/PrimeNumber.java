package com.gl.primenumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static List<Integer> primeNumbers(int number) {
        return IntStream.range(1, number)
                .filter(PrimeNumber::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(e -> number % e == 0);
    }
}
