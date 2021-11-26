package com.gl.Constructor;

public class ConstructorDemo {
    public static void main(String[] args) {

        Table table = new Table();
        System.out.println(table);
        table.setLength(45);
        System.out.println(table);

        Table table1 = new Table(10, 20, 15);
        System.out.println(table1);

        Table table2 = new Table(10, 15);
        System.out.println(table2);

        Table copy = new Table(table2);
        System.out.println(copy);

        Table table3 = new Table(30);
        System.out.println(table3);
    }
}

class Base {
    Base() {
        System.out.println("Base class constructor");
    }

    Base(double d) {
        System.out.println("Parameterized Base class constructor");
    }
}

class Table extends Base {
    double length;
    double width;
    double height;

    public Table() {
        this(10, 10, 10);
        System.out.println("Default constructor");
    }

    public Table(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        System.out.println("Parameterized constructor");
    }

    public Table(double length, double height) {
        this(length, length, height);
        System.out.println("Parameterized constructor");
        //this(length, length, height); - NOT allowed. this() call must be first line
    }

    public Table(double length) {
        super(length);
        this.length = length;
        this.width = length;
        this.height = length;
        System.out.println("Parameterized constructor");
        //super(length); - NOT allowed. super() call must be first line
    }

    public Table(Table another) {
        this.length = another.length;
        this.width = another.width;
        this.height = another.height;
        System.out.println("Copy constructor");
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Table{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}