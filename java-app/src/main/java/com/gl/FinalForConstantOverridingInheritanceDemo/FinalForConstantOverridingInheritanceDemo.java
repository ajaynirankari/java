package com.gl.FinalForConstantOverridingInheritanceDemo;

public class FinalForConstantOverridingInheritanceDemo {
    public static void main(String[] args) {

        Test obj = new Test(50);
        obj.show();
        obj.display();
        //obj = new SubClass();
        //obj.display();

        System.out.println(In1.COUNT);
        //In1.COUNT=200;

        int b = 20;

        Runnable runnable = () -> {
            System.out.println("b == "+b);
            //b++;
            //b=40;
        };

        runnable.run();
    }
}

interface In1 {
    int COUNT = 100;
}

final class Test {

    final int a = 100;
    final int x;

    Test() {
        this.x = 100;
    }

    Test(int x) {
        this.x = x;
    }

    void show() {
        final int c;
        c = 10;
        System.out.println("c=" + c);
        //c=20;
        //c++;
        System.out.println("c=" + c);
        System.out.println("a=" + a + " x=" + x);
        //a++;
        //a=20;
        System.out.println("a=" + a + " x=" + x);
    }

    final public void display() {
        System.out.println("Test :: display()");
    }
}

//class SubClass extends Test {
//    @Override
//    public void display() {
//        System.out.println("SubClass :: display()");
//    }
//}
