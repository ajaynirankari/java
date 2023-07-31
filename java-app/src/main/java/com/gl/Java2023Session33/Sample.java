package com.gl.Java2023Session33;

public class Sample {
    public static void main(String[] args) {

        //Table tableObject1 = new Table(); This is NOT allowed, due to default constructor is private

        Table tableObject1 = new Table(10);
        System.out.println("tableObject1.length = " + tableObject1.getLength());
        System.out.println("tableObject1.width = " + tableObject1.getWidth());
        System.out.println("tableObject1.height = " + tableObject1.getHeight());
        System.out.println("--------------------------------------------------------");

        Table tableObject2 = new Table(20, 5);
        System.out.println("tableObject2.length = " + tableObject2.getLength());
        System.out.println("tableObject2.width = " + tableObject2.getWidth());
        System.out.println("tableObject2.height = " + tableObject2.getHeight());
        System.out.println("--------------------------------------------------------");

        Table tableObject3 = new Table(20, 5, 30);
        System.out.println("tableObject3.length = " + tableObject3.getLength());
        System.out.println("tableObject3.width = " + tableObject3.getWidth());
        System.out.println("tableObject3.height = " + tableObject3.getHeight());
        System.out.println("--------------------------------------------------------");

        tableObject3.setLength(40);
        //tableObject3.width = 0; // Not allowed

        System.out.println("tableObject3.length = " + tableObject3.getLength());
        System.out.println("tableObject3.width = " + tableObject3.getWidth());
        System.out.println("tableObject3.height = " + tableObject3.getHeight());
        System.out.println("--------------------------------------------------------");


        Employee e1 = new Employee(101, "Sam", 45);
        System.out.println("e1 -> Id: " + e1.getId() + ", Name: " + e1.getName() + ", Age: " + e1.getAge());
        e1.setAge(0);
        System.out.println("e1 -> Id: " + e1.getId() + ", Name: " + e1.getName() + ", Age: " + e1.getAge());

        e1.setAge(59);
        e1.setName("John");
        //e1.age=99990;       // Not allowed
        System.out.println("e1 -> Id: " + e1.getId() + ", Name: " + e1.getName() + ", Age: " + e1.getAge());
        System.out.println("--------------------------------------------------------");

        EmployeeClassUsingRecord e2 = new EmployeeClassUsingRecord(102, "Smith", 34);
        System.out.println("e2 = " + e2);
        System.out.println("e2 -> Id: " + e2.id() + ", Name: " + e2.name() + ", Age: " + e2.age());
    }
}

class Table {
    private int length;
    private int width;
    private int height;

    private Table() {
        System.out.println("Default Constructor");
    }

    Table(int l) {
        System.out.println("One Argument Constructor");
        length = l;
        width = l;
        height = l;
    }

    Table(int l, int w) {
        System.out.println("Two Argument Constructor");
        length = l;
        width = w;
        height = l;
    }

    Table(int l, int w, int h) {
        System.out.println("Three Argument Constructor");
        length = l;
        width = w;
        height = h;
    }

    int getLength() {
        return length;
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    void setLength(int len) {
        if (len > 10 && len < 500) {
            length = len;
        }
    }

    void setHeight(int h) {
        if (h > 10 && h < 50) {
            height = h;
        }
    }

    void setWidth(int w) {
        if (w > 10 && w < 80) {
            width = w;
        }
    }
}

class Employee {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18 && age < 70) {
            this.age = age;
        }
    }

    public void setName(String name) {
        if (name.length() > 3) {
            this.name = name;
        }
    }
}

record EmployeeClassUsingRecord(int id, String name, int age) {}