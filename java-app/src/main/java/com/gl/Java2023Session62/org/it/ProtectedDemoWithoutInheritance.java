package com.gl.Java2023Session62.org.it;

public class ProtectedDemoWithoutInheritance {
    void test(){
        ProtectedDemo protectedDemo = new ProtectedDemo();
        System.out.println("protectedDemo.protectedVar = " + protectedDemo.protectedVar);
        System.out.println("protectedDemo.publicVar = " + protectedDemo.publicVar);
        System.out.println("protectedDemo.defaultVar = " + protectedDemo.defaultVar);
        //System.out.println("protectedDemo.privateVar = " + protectedDemo.privateVar);
    }

}
