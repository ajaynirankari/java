package com.gl.PreferCompositionOverInheritance;

public class PreferCompositionOverInheritanceDemo {
    public static void main(String[] args) {
        Manager manager;
        //manager = new Manager(new Employee());
        //manager.work();
        //manager.manage();

        manager = new Manager(new SmartEmployee());
        manager.manage();

        manager = new Manager(new LazyEmployee());
        manager.manage();

        new Manager(new ExtraOrdinaryEmployee()).manage();

        new  Manager(new Employee() {
            @Override
            public void work() {
                System.out.println("Anonymous employee doing work");
            }
        }).manage();

        new Manager(()-> System.out.println("Lambda employee doing work")).manage();

        new Manager(Test::test).manage();

    }
}

class Test{
    static public void test(){
        System.out.println("Testing employee is doing work");
    }
}

//class Employee {
interface Employee {
    //    public void work() {
//        System.out.println("Employee doing work");
//    }
    public void work();

    public default int manage() {
        return 0;
    }
}

//class Manager extends Employee { // IS-A Relationship, Inheritance - Tight coupling
class Manager {
    Employee employee; // HAS-A Relationship, Composition - Loose coupling, Interfaced composition

    public Manager(Employee employee) {
        this.employee = employee;
    }

    public void manage() {
        employee.work();
        System.out.println("Manager manage employee");
    }

}

class SmartEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("SmartEmployee doing work");
    }
}

class LazyEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("LazyEmployee doing work");
    }
}

class ExtraOrdinaryEmployee implements Employee {
    @Override
    public void work() {
        System.out.println("ExtraOrdinaryEmployee doing work");
    }
}