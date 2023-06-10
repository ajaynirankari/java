package com.gl.Java2023Session02;

public class Sample {
    public static void main(String[] args) {
        // Java is statically type language

        // DataType
        // 1 - Primitive Data Type    (value)
        // 2 - Non-Primitive Data Type (it have method, property, field)
        //     (Use Defined Data Type)

        /**
         * Primitive Data Type
         * byte    - 8 bit
         * short   - 16 bit
         * int     - 32 bit
         * long    - 64 bit
         *
         * float    - 32 bit
         * double   - 64 bit
         *
         * char     - 16 bit
         *
         * boolean  - true / false
         *
         * Non-primitive data type
         *    String  (class)
         *    User (class)
         *
         */

        byte age = 40;
        short calculation = 60;
        int getAge = 19;
        long lng = 56l;

        float ab = 45.6f;
        double db = 89.9;

        char check = 's';

        // Variable Declaration
        int x;
        System.out.println(ab);
        //System.out.println(x);

        // Initialization
        x = 89;
        System.out.println(x);

        // <DataType> <Variable Name>;
        // Declaration                      int b;
        // Initialization                   b=90;

        // <DataType> <Variable Name> = <Value>;
        // Declaration + Initialization     int b = 78;

        int _test = 80;
        int $test1 = 80;

        int x1 = 9;
        int y = 80;
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = x1 > y;
        System.out.println("b3 = " + b3);

        char ch = 'a';
        System.out.println("ch = " + ch);
        char ch1 = 65;
        System.out.println("ch1 = " + ch1);
        char ch2 = 97;
        System.out.println("ch2 = " + ch2);

        String s = "Hello";
        System.out.println("s = " + s);

        String name;
        name = "Test";
        System.out.println("name = " + name.toLowerCase());

        var t = 30;
        System.out.println("t = " + t);

        var ss = 78;
        //System.out.println("ss = " + ss.toUpperCase());

        //var h;
        //h=90;
        //System.out.println("h = " + h);

        MyObject obj;
        obj = new MyObject();
        System.out.println("obj = " + obj);

        User user1 = new User();
        System.out.println("user1.name = " + user1.name);
        System.out.println("user1.age = " + user1.age);
        System.out.println(" ============ ");

        user1.name = "John";
        user1.age = 56;

        System.out.println("user1.name = " + user1.name);
        System.out.println("user1.age = " + user1.age);
    }
}

class User {    // class Name / User defined data type name
    String name;   // Variable name, field, property
    int age; // Variable name, field, property
}

class MyObject {
    int x;
    float f;
    double d;
    long h;
}