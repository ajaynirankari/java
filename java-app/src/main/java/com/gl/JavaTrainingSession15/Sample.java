package com.gl.JavaTrainingSession15;

public class Sample {
    public static void main(String[] args) {
        // IS-A -> Inheritance -> tight coupling, strong relation -> Change in super class can impact in subclass
        // HAS-A -> Composition -> loose coupling, weak relation -> NO such impact

        Engine engine = new Engine();
        Car car = new Car(123, "Sport", engine);
        SportCar s = new SportCar();
    }
}

class Car {
    int modelNo;
    String type;
    Engine engine;  // HAS-A  -> Composition, Composite object

    public Car(int modelNo, String type, Engine engine) {
        this.modelNo = modelNo;
        this.type = type;
        this.engine = engine;
    }
}

class Engine {
}

class SportCar extends Car { //IS-A   -> Inheritance
    SportCar() {
        super(124, "SportCar", new Engine());
    }
}

class LuxuryCar extends Car { //IS-A   -> Inheritance
    LuxuryCar() {
        super(125, "LuxuryCar", new Engine());
    }
}

class Employee {
    String firstName;
    String LastName;
    Animal animal; // HAS-A  -> Composition
    Car car; // HAS-A  -> Composition
}

class PermanentEmp extends Employee { // IS-A   -> Inheritance

}

class AdhocEmp extends Employee { // IS-A   -> Inheritance

}

class Animal {
}

class Cat extends Animal { // IS-A   -> Inheritance
}