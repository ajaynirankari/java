package com.gl.ConstructorDemo;

public class ConstructorDemo {
    public static void main(String[] args) {

        Test obj = new Test();
        Test obj1 = new Test(101);
        Test obj2 = new Test(101, 202);

        Direction enumObj = Direction.EAST;
        System.out.println(enumObj);
        System.out.println(enumObj.getValue());

        Employee employee1 = new Employee(101, "Josh", 34);
        System.out.println(employee1);
        Employee employee2 = new Employee("Smith");
        System.out.println(employee2);
        Employee employee3 = new Employee();
        System.out.println(employee3);

    }
}

record Employee(int id, String name, int salary) {
    Employee() {
        this(0, null, 0);
    }

    Employee(String name) {
        this(0, name, 0);
    }

}

enum Direction {
    EAST(1), WEST(2), NORTH(3), SOUTH(4);

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class Test {
    int field1;
    int field2;

    // Default constructor
    // Compiler generated constructor
    // No-Argument constructor
    Test() {
    }

    // User define constructor
    Test(int field1) {
        this.field1 = field1;
    }

    // Parameterized constructor
    Test(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }
}
