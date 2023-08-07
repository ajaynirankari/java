package com.gl.Java2023Session37;

public class Sample {
    public static void main(String[] args) {

        A objectA = new A();
        objectA.say();
        //objectA.hello();

        B objectB = new B();
        objectB.say();
        objectB.hello();

        C objectC = new C();
        objectC.say();
        //objectC.hello()

        D objectD = new D();
        objectD.say();


        AA aa = new AA();
        //aa.hello();
        aa.say();

        BB bb = new BB();
        bb.hello();
        bb.say();

        CC cc = new CC();
        cc.hello();
        cc.say();

        A a = new A();
        a.say();

        A a2 = new B();
        a2.say();
        //a2.hello();

        A a1 = new C();
        a1.say();
        //a1.hello();

        A a3 = new D();
        a3.say();

        C b = new C();
        //C c = new B();
        B b1 = new B();
        b1.hello();
        b1.say();

        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();

        SuperClass superClass1 = new SubClass();
        //SubClass subClass1 = new SuperClass();

        printSuperClass(superClass);
        printSuperClass(subClass);

        printSubClass(subClass);
        //printSubClass(superClass);

        Test test = new Test();
        Hello hello = new Hello();
        //Test test1 = new Hello();
    }

    static void printSubClass(SubClass subClass) {
        subClass.say();
        subClass.subSay();
    }

    static void printSuperClass(SuperClass superClass) {
        superClass.say();
    }
}


class SuperClass {
    void say() {
        System.out.println("SuperClass say ()");
    }
}

class SubClass extends SuperClass {
    void subSay() {
        System.out.println("SubClass subSay ()");
    }
}

class A {
    void say() {
        System.out.println("A() say ");
    }
}

class B extends A {
    void hello() {
        System.out.println("B() Hello");
    }

    void say() {
        System.out.println("B() say ");
    }
}

class C extends A {
    void say() {
        System.out.println("C() say ");
    }
}

class D extends A {

}

class AA {
    void say() {
        System.out.println("AA() say ");
    }
}

class BB extends AA {
    void hello() {
        System.out.println("BB() Hello");
    }
}

class CC extends BB {

}

class DD extends CC {

}

class Test {
}

class Hello {
}