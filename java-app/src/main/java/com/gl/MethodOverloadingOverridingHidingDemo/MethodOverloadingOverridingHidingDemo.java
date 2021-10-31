package com.gl.MethodOverloadingOverridingHidingDemo;

public class MethodOverloadingOverridingHidingDemo {
    public static void main(String[] args) {

        Test obj = new Test();
        System.out.println(obj.sum(10, 20));                // Method Overloading (compile-time polymorphism)
        System.out.println(obj.sum(101.1f, 201.1f));        // Method Overloading (compile-time polymorphism)
        System.out.println(obj.sum(10, 20, 30));         // Method Overloading (compile-time polymorphism)
        System.out.println(obj.sum(10, 20, 30.3f));      // Static Method Overloading (compile-time polymorphism)

        Base base = new Base();
        callMethod(base);
        base = new SubClass();
        callMethod(base);

    }

    static void callMethod(Base obj) {
        obj.show();                                         // Method Overriding (runtime polymorphism)
        obj.display();                                      // Method Hiding

        Base.display();
        SubClass.display();
    }
}

class Base {
    Number show() {
        System.out.println("Base :: show() ");
        return null;
    }

    static void display() {
        System.out.println("Base :: display() ");
    }
}

class SubClass extends Base {

    Number show(int x) {
        System.out.println("Base :: show() ");
        return null;
    }

    @Override
    Integer show() {
        System.out.println("SubClass :: show() ");
        return null;
    }

    static void display() {
        System.out.println("SubClass :: display() ");
    }
}

class Test {
    int sum(int a, int b) {
        System.out.println("sum(int a, int b)");
        return a + b;
    }

    int sum(int a, int b, int c) {
        System.out.println("sum(int a, int b, int c)");
        return a + b + c;
    }

    float sum(float a, float b) {
        System.out.println("sum(float a, float b)");
        return a + b;
    }

    static float sum(int a, int b, float f) {
        System.out.println("sum(int a, int b,float f)");
        return a + b + f;
    }
}
