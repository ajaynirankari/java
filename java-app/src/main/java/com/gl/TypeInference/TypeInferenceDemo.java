package com.gl.TypeInference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TypeInferenceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();

        numbers.add(12);
        numbers.add(13);
        //numbers.add("Hello");                                         // NOT ALLOWED
        System.out.println(numbers);

        List<String> strs = new ArrayList<String>();
        strs.add("one");
        strs.add("two");
        strs.add("hello");
        //strs.add(123);                                               // NOT ALLOWED
        System.out.println(strs);

        List<Integer> nums = new ArrayList<>();
        nums.add(23);

        Predicate<String> predicate = (String t) -> t.length() == 0;
        Predicate<String> predicate1 = (t) -> t.length() == 0;
        Predicate<String> predicate11 = t -> t.length() == 0;

        numbers.forEach((Integer n) -> System.out.println(n));

        //numbers.forEach(n -> System.out.println(n.foo()));

        List<Integer> number1 = new ArrayList<>() {{
            add(12);
            add(34);
            //add("Hello");                                             // NOT ALLOWED
        }};

        List number2 = new ArrayList<>() {{
            add(12);
            add(34);
            add("Hello");
        }};


        String str = "Hello";
        System.out.println(str + " " + str.length());
        var str1 = "hello";
        System.out.println(str1 + " " + str1.length());
        //str1.foo();

        var integers = List.of(1, 2, 3, 4);

        var age = 10;
        //age.foo();                                                    // NOT ALLOWED
        //var id;
        //var obj = null;                                               // NOT ALLOWED


        Runnable runnable = () -> System.out.println("in runnable");
        //var runnable1 = () -> System.out.println("in runnable");      // NOT ALLOWED

        MyInterface myMyInterface = () -> System.out.println("MyInterface");
        MyInterface myMyInterface1 = () -> System.out.println("in runnable");

        var obj = List.of("one", 1, 1.0);


        var var = 123;
        System.out.println(var);
        var num = 12.3;

    }
}

interface MyInterface {
    void run();
}

class Test {
    String name;
    //var age;                           // NOT ALLOWED
    void show(String name) {

    }
//    void show1(var name) {            // NOT ALLOWED
//
//    }
}
