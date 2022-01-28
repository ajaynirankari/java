package com.gl.JavaTrainingSession12;

public class Sample {
    public static void main(String[] args) {

        int a = 10;
        int x = 90;
        double b = 34.2;
        System.out.println("b = " + b + ", a=" + a);
        a = x; // it is OK, can assign int to int
        //a = b; // it is NOT allowed, can not assign double to int
        a = (int) b; // Need type cast, assign double to int
        System.out.println("b = " + b + ", a=" + a);
        b = a; // it is OK, int can assign to double


        SuperClass superClass = new SuperClass();
        superClass.show();

        SubClass subClass = new SubClass();
        subClass.show();
        subClass.display();

        SuperClass superClass1 = new SubClass();
        superClass1.show();
        //superClass1.display(); NOT allowed, From super class reference,can not call sub-class method

        //subClass = superClass; // It is NOT allowed to assign super-class object to sub-class reference

        superClass = subClass; // It is allowed to assign sub-class object to super class reference

        subClass = (SubClass) superClass; // here need type cast,if you want to assign super-class object to sub-class reference. it is only possible when above line exist -> superClass = subClass
        subClass.show();
        subClass.display();

        superClass = new SuperClass();
        check(superClass);
        superClass = new SubClass();
        check(superClass);

        check(new SuperClass());
        check(new SubClass());

        checkOne(new SubClass());
        //checkOne(new SuperClass());
    }

    static void check(SuperClass obj) {
        obj.show(); // run-time polymorphism, show() output is not bound at compile time. at run time it will bound which class method will invoke
        //obj.display();
    }

    static void checkOne(SubClass obj) {
        obj.show();
        obj.display();
    }
}

class SuperClass {
    SuperClass() {
        System.out.println(" SuperClass() ");
    }

    int x = 100;

    void show() {
        System.out.println("In side SuperClass show()");
    }
}

class SubClass extends SuperClass {
    SubClass() {
        System.out.println(" SubClass()");
    }

    int x = 200;

    void show() {
        super.show();
        System.out.println("In side SubClass show()");
    }

    void display() {
        System.out.println("super.x = " + super.x);
        System.out.println("SubClass  - display()");
    }
}

//Multi-level Inheritance – Java Class support
class AA {
}

class BB extends AA {
}

class CC extends BB {
}

class DD extends CC {
}

//Hierarchical Inheritance – Java Class support
class A {
}

class B extends A {
}

class C extends A {
}

class D extends A {
}

class AAA {
}

// Single Inheritance – Java Class support
class BBB extends AAA {
}

// Multiple Inheritance – Java Class NOT support
// class CCC extends AAA, BBB {}