package com.gl.Java2023Session38;

public class Sample {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.shape();
        Rectangle rectangle = new Rectangle();
        rectangle.shape();
        Triangle triangle = new AnotherTriangle();
        triangle.shape();
        triangle.area();

        //Shape shape = new Shape();  ------> Object of Abstract class CAN NOT allow to create
        //shape.shape();

        Shape shape = new Circle();// ------> Object of subclass CAN assign to Abstract class reference
        shape.shape();
        shape.test();
        shape.area();
        //shape = new Triangle();
        //shape.shape();

        //NewShape newShape = new NewShape();  ------> Object of Interfaced CAN NOT allow to create

        NewShape newShape = new NewShapeImplementation1(); // ------> Object of implementation class CAN assign to Interface reference
        newShape.area();
        newShape.shape();
        newShape.test();
    }
}

interface NewShape {
    public static final int max = 100;
    int min = 1;                      // By default variable is public static final

    void shape();                     // By default the method is public abstract

    abstract void area();

    default void test() {            // default method is allowed in interface
        System.out.println("Test");
    }
}

class NewShapeImplementation1 implements NewShape {
    @Override
    public void area() {
        System.out.println("area");
    }

    @Override
    public void shape() {
        System.out.println(" shape");
    }
}

class NewShapeImplementation2 implements NewShape {
    @Override
    public void area() {
        System.out.println("area");
    }

    @Override
    public void shape() {
        System.out.println(" shape");
    }
}


abstract class Shape {
    int instanceVariable = 100;

    abstract void shape();

    abstract void area();

    void test() {
        System.out.println("Test");
    }

    Shape() {
        System.out.println("Constructor");
    }
}


class Circle extends Shape {
    void shape() {
        System.out.println("circle shape");
    }

    @Override
    void area() {
        System.out.println(" circle area ");
    }
}

class Rectangle extends Shape {
    void shape() {
        System.out.println("Rectangle shape");
    }

    @Override
    void area() {
        System.out.println("Rectangle area ");
    }
}

abstract class Triangle extends Shape {
    void shape() {
        System.out.println("Triangle shape");
    }
}

class AnotherTriangle extends Triangle {
    @Override
    void area() {
        System.out.println("AnotherTriangle area");
    }
}
