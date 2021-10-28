package com.gl.AutoboxingVsUnboxing;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingVsUnboxingDemo {
    public static void main(String[] args) {
        int a = 10;                                 // Primitive Type
        System.out.println(a);
        Integer aObj = a;                           // Wrapper Classes - Integer
        System.out.println(aObj);

        Integer intObj = Integer.valueOf(500);
        int primitive = intObj;                       // Autoboxing : Auto convert object to primitive
        Integer intObj1 = 300;                        // Unboxing : Auto convert primitive to object


        List<Integer> list = new ArrayList<>();
        list.add(aObj);
        list.add(50);                               // Autoboxing
        System.out.println(list);

        Integer integer = list.get(0);
        int b = list.get(0);                        // Unboxing
        System.out.println(b);
    }
}
