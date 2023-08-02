package com.gl.Java2023Session35;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {

        Engine e1 = new Engine();
        Engine e2 = new Engine(100);
        Engine e3 = new Engine(300);

        System.out.println("--------------------------");
        Car car1 = new Car(e2);
        System.out.println("-----------car1---------------> " + car1);

        String[] sideMirrors1 = {"OneSideMirror"};
        car1.setSideMirrors(sideMirrors1);
        System.out.println("-----------car1---------------> " + car1);

        Car car2 = new Car(e3);
        System.out.println("-----------car2---------------> " + car2);

        String[] sideMirrors2 = {"OneSideMirror","TwoSideMirror"};
        car2.setSideMirrors(sideMirrors2);
        System.out.println("-----------car2---------------> " + car2);
    }
}

class Car {
    private Engine engine;   // HAS A or Composition or Loose Coupling with strong bonding
    private String[] sideMirrors; // HAS A or Composition or Loose Coupling with week bonding

    Car(Engine engine) {
        this.engine = engine;
        System.out.println("Car with engine engine.getPower() = " + engine.getPower());
    }

    public void setSideMirrors(String[] sideMirrors) {
        this.sideMirrors = sideMirrors;
    }

    @Override
    public String toString() {
        return "Car{" + "engine = " + engine + ", sideMirror = " + Arrays.toString(sideMirrors) + '}';
    }
}

class Engine {
    private int power = 0;

    Engine() {
        System.out.println("Engine with default power setting");
    }

    Engine(int x) {
        this.power = x;
        System.out.println("Engine with " + x + " power");
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Engine{" + "power = " + power + '}';
    }
}

class Animal {
}

class Cat extends Animal { // IA A or Inheritance or Tight Coupling

}