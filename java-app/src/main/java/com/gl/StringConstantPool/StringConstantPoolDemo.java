package com.gl.StringConstantPool;

public class StringConstantPoolDemo {
    public static void main(String[] args) {

        String s = "Hello"; // String literals "Hello" store in string pool memory
        String s1 = "Hello"; // Refer the same string literals "Hello" of string pool memory

        String s2 = new String("abc"); // String literals "Hello" store in string pool memory and new string
                                             // object is created in heap memory also

        String s3 = new String("Hello"); // Refer the same string literals "Hello" of string pool memory and
                                                // new string object is created in heap memory also

        System.out.println("s= " + s.intern());
        System.out.println("s1= " + s1.intern());
        System.out.println("s3= " + s3.intern()); // intern() return the reference of the string pool memory
    }
}