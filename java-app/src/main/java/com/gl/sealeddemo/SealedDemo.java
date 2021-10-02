package com.gl.sealeddemo;

public class SealedDemo {
    public static void main(String[] args) {

        Shape shape = new Circle();

        System.out.println("OK");
    }
}

sealed interface SealedInterface permits I1Impl, I2Impl {

}

final class I1Impl implements SealedInterface {

}

non-sealed class I2Impl implements SealedInterface {

}

class Sub extends I2Impl {
}

sealed abstract class Shape permits Circle, Triangle {
}

final class Circle extends Shape {
}

final class Triangle extends Shape {

}
//final class Square extends Shape{
// Not allowed
//}


interface Vehicle {
}

class A implements Vehicle {
}

class B implements Vehicle {
}

class C implements Vehicle {
}
