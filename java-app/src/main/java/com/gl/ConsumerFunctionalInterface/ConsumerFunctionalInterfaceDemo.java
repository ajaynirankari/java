package com.gl.ConsumerFunctionalInterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterfaceDemo {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        list.forEach(System.out::println);

        MyConsumer myConsumer = new MyConsumer();
        list.forEach(myConsumer);

        Consumer myConsumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        list.forEach(myConsumer1);

        Consumer<Integer> myConsumer2 = (Integer integer) -> {
            System.out.println(integer);
        };
        list.forEach(myConsumer2);

        Consumer<Integer> myConsumer3 = (integer) -> {
            System.out.println(integer);
        };
        list.forEach(myConsumer3);

        Consumer<Integer> myConsumer4 = (integer) -> System.out.println(integer);
        list.forEach(myConsumer4);


        list.forEach(integer -> System.out.println(integer));

        list.forEach(ConsumerFunctionalInterfaceDemo::printElement);

        list.forEach(System.out::println);
    }
    static void printElement(int e){
        System.out.println(e);
    }
}

class MyConsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer integer) {
        System.out.println(integer);
    }
}
