package com.gl.Java2023Session62.org;

import com.gl.Java2023Session62.org.it.ITFuc;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main");
        Test test = new Test(45);
        System.out.println("test.x = " + test.x);

        ITFuc itFuc = new ITFuc();
        //itFuc.test();      can not access default method()
        itFuc.testPublic();
        // itFuc.testPrivate(); can not access private method()

        //FinCalculation finCalculation = new FinCalculation()
    }
}

class Test {
    int x;

    Test(int a) {
        x = a;
    }

}
