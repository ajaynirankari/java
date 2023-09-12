package com.gl.Java2023Session62.org.it;

public class ProtectedDemo {
    private int privateVar = 1;
    protected int protectedVar = 2;
    public int publicVar = 3;
    int defaultVar = 4;

    void test() {
        System.out.println("privateVar = " + privateVar);
    }
    private void test1() {
        System.out.println("privateVar = " + privateVar);
    }
    protected void test2() {
        System.out.println("privateVar = " + privateVar);
    }
}
