package com.gl.RecordClasse;

public class Sample {
    public static void main(String[] args) {

        Employee employee = new Employee(101, "John", "john@gmail.com");

        System.out.println("employee = " + employee);
        System.out.println("employee.name() = " + employee.name());
        System.out.println("employee.email() = " + employee.email());
        System.out.println("employee.id() = " + employee.id());
        System.out.println("employee.hashCode() = " + employee.hashCode());

        Employee employee1 = new Employee("Michle");
        System.out.println("employee1 = " + employee1);

//        Employee employee2 = new Employee("M");
//        System.out.println("employee1 = " + employee2);

        test(employee);
        test(new TestD());

    }

    static void test(Object object) {
        System.out.println("object.getClass().isRecord() = " + object.getClass().isRecord());
    }
}

record Employee(int id, String name, String email) {

    Employee {
        if (name.length() < 2) throw new IllegalArgumentException("Name can not be less than 2");
    }

    Employee(String name) {
        this(1, name, "eamil@gmail.com");
    }

    static String test;

    static String getTest() {
        return test;
    }

    static {
        test = "Dummy";
    }

    public int getData() {
        return id;
    }

    class NestedClass {
    }

    static class NestedClass1 {
    }

    interface NestedInterface {
    }

    record NestedRecordClass() {
    }

}

interface MyInterface {
}

interface MyInterface1 {
}

record Test() implements MyInterface, MyInterface1 {
    static int x;
//    int y;
//    {
//        y=10;
//    }

}

class TestD {
}
//record Test1() extends TestD {}

//abstract record Dept() {}
