package com.gl.ThisVsSuper;

public class ThisVsSuperDemo {
    public static void main(String[] args) {
        new Base().methodA(100);
        new Base(50);
        new Base();
        new Sub();
        new Sub(56);
    }
}

class Base {
    int a;

    Base() {
        this(999);
        System.out.println("Base() Local a = " + a);
        System.out.println("Base() Instance this.a = " + this.a);
    }

    Base(int a) {
        //this();
        this.a = a;
        a = 123;
        System.out.println("Base(a) Local a = " + a);
        System.out.println("Base(a) Instance this.a = " + this.a);
        this.methodA(98);
        methodA();
    }

    void methodA(int a) {
        System.out.println("methodABase(a) Local a = " + a);
        System.out.println("methodABase(a) Instance this.a = " + this.a);
    }

    void methodA() {
        System.out.println("methodABase() Local a = " + a);
        System.out.println("methodABase() Instance this.a = " + this.a);
    }
}

class Sub extends Base {
    int a;

    Sub() {
        super(7777);
        //this(888);
        System.out.println("Sub() Local = " + a);
        System.out.println("Sub() Instance this = " + this.a);
        System.out.println("Sub() super Instance = " + super.a);
        super.methodA();
    }

    Sub(int a) {
        super(a);
        this.a = a;
        System.out.println("Sub(a) Local = " + a);
        System.out.println("Sub(a) Instance this = " + this.a);
        System.out.println("Sub(a) super Instance = " + super.a);
    }

    void methodA() {
        System.out.println("methodASub() Local a = " + a);
        System.out.println("methodASub() Instance this.a = " + this.a);
        System.out.println("methodASub() Instance super.a = " + super.a);
    }
}
