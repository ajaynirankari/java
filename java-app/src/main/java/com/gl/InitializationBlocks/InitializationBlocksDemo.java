package com.gl.InitializationBlocks;

public class InitializationBlocksDemo {
    public static void main(String[] args) {
        Base b = new Base();
        Sub s = new Sub();
    }
}

class Base {
    int a;   // instance variable or object variable
    static int s; // static variable or class variable


    static {
        System.out.println("static initialization another block " + s);
    }

    static int ss;

    {
        System.out.println("instance initialization another block");
    }

    void method() {
        aa = 45;
        System.out.println("instance method block");
    }

    static void methodS() {
        bb = 12;
        System.out.println("static method block ");
    }

    Base() {
        System.out.println("----constructor initialization block " + a + " " + aa);
        a = 12;
        aa = 23;
        System.out.println("constructor initialization block " + a + " " + aa);
    }

    {
        System.out.println("------instance initialization block " + a);
        a = 100;
        System.out.println("instance initialization block " + a);
    }

    static {
        System.out.println("static initialization block" + s);
    }

    int aa;
    static int bb;
}

class Sub extends Base {
    int v;
    static int vv;

    {
        v = 10;
        System.out.println("Sub - Instance init block");
    }

    static {
        vv = 34;
        System.out.println("Sub - Static init block");
    }

    Sub() {
        v = 14;
        System.out.println("Sub - Constructor init block");
    }
}