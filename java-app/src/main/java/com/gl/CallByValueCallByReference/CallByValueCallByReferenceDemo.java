package com.gl.CallByValueCallByReference;

public class CallByValueCallByReferenceDemo {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println("Before swap() call in main method -> a=" + a + ",b=" + b);
        swap(a, b);
        System.out.println("After swap() call in main method -> a=" + a + ",b=" + b);

        MyClass ref = new MyClass(a, b);
        System.out.println("Before swap() call in main method -> a=" + ref.a + ",b=" + ref.b);
        swap(ref);
        System.out.println("After swap() call in main method -> a=" + ref.a + ",b=" + ref.b);

    }

    static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
        System.out.println("In side swap(int,int) method -> a=" + a + ",b=" + b);
    }

    static void swap(MyClass ref) {
        int t = ref.a;
        ref.a = ref.b;
        ref.b = t;
        System.out.println("In side swap(ref) method -> a=" + ref.a + ",b=" + ref.b);
    }
}

class MyClass {
    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }
}