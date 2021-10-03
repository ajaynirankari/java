package com.gl.randomgeneratordemo;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class RandomGeneratorDemo {
    public static void main(String[] args) {

        RandomGenerator randomGenerator = RandomGenerator.getDefault();

        System.out.println(randomGenerator.nextInt(100));
        System.out.println(randomGenerator.nextInt(100));

        Random random = new Random();
        System.out.println(random.nextInt(100));
        System.out.println(random.nextInt(100));


        System.out.println(randomGenerator.ints(100, 500).limit(20).boxed().collect(Collectors.toList()));

        System.out.println(randomGenerator.doubles(100, 300).limit(5).boxed()
                .collect(Collectors.toList()));

        System.out.println(randomGenerator.longs(1000, 5000).limit(10).boxed().collect(Collectors.toList()));


        RandomGenerator xoshiro256PlusPlus = RandomGenerator.of("Xoshiro256PlusPlus");

        System.out.println(xoshiro256PlusPlus.ints(10, 50).limit(8).boxed().collect(Collectors.toList()));
    }
}
