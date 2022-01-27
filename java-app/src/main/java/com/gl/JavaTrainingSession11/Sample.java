package com.gl.JavaTrainingSession11;

public class Sample {
    public static void main(String[] args) {

        Base obj = new Base();
        System.out.println("obj.variable1 = " + obj.variable1);
        obj.calculate(40, 20);

        SubClass subClass = new SubClass();
        subClass.calculate(20, 10); // Overridden method called
        subClass.calculate(10, 20.2); //Overloaded method called
        subClass.sum(20, 20); // sum() is overload method with in int, int parameters
        subClass.sum(20, 20, 30); // sum() is overload method with in int, int, int parameters

        Base baseObj = new Base();
        baseObj.calculate(2, 3);

        Base baseObj1 = new SubClass();
        baseObj1.calculate(4, 5); // Overridden method called
        baseObj1.another();
        //baseObj1.sum(1, 2);  it is not allowed to call sum(), sum() is NOT defined in Base class

        SubClass suObj = new SubClass();
        suObj.calculate(2, 5);
        suObj.sum(2, 3);

        Base baseObj2;
        baseObj2 = new Base();
        show(baseObj2);
        baseObj2 = new SubClass();
        show(baseObj2);

        Base b = new Base();
        Base b1 = new SubClass(); // Only possible it due to Inheritance

    }

    static void show(Base base) {
        base.calculate(2, 4);// Runtime Polymorphism - calculate() is invoked of base class or subclass, it decides at run time
    }

}

class Base {

    Base() {
        System.out.println("Base() variable1 = " + variable1);
    }

    public int variable1 = 100;

    int calculate(int x, int y) {
        int s = x + y;
        System.out.println("Base class x = " + x + ", y= " + y + ", sum=" + s);
        return s;
    }

    int another() {
        System.out.println("variable1 = " + variable1);
        return variable1;
    }
}

class SubClass extends Base {

    SubClass() {
        System.out.println("SubClass() variable1=" + variable1);
    }

    int variable1 = 200;

    // Method Overloading
    int calculate(int x, double y) {
        int s = x * (int) y;
        System.out.println("SubClass class x = " + x + ", y= " + y + ", mul=" + s);
        return s;
    }

    // Method Overriding
    @Override
    int calculate(int x, int y) {
        int s = x * y;
        System.out.println("SubClass class x = " + x + ", y= " + y + ", mul=" + s);
        return s;
    }

    // Method Overloading
    int sum(int x, int y) {
        int s = x + y;
        System.out.println("SubClass class x = " + x + ", y= " + y + ", s=" + s);
        return s;
    }

    // Method Overloading
    int sum(int y, int x, int z) {
        System.out.println("this.variable1 = " + this.variable1);
        System.out.println("super.variable1 = " + super.variable1);
        int calculate = super.calculate(x, y);
        int s = calculate + z;
        System.out.println("SubClass class x = " + x + ", y= " + y + ", s=" + s);
        return s;
    }
}
