package com.gl.Java2023Session31;

public class Sample {
    public static void main(String[] args) {

        Table table1 = new Table(20, 30, 15);                   // <------ table1 is an object of blueprint class Table

        System.out.println("table1.printTable() = " + table1.printTable());
        System.out.println("table1 = " + table1);
        String string = table1.toString();
        System.out.println("table1 toString() = " + string);

        Table table2 = new Table(22, 44, 20);                   // <------ table2 is an object of blueprint class Table
        System.out.println("table2 = " + table2);

        Table table3 = new Table(45, 77, 388);                  // <------ table3 is an object of blueprint class Table
        System.out.println("table3 = " + table3);

        int area = table3.area();                                       // <------ area() is behavior of object table3
        System.out.println("area = " + area + " of table " + table3);
        String shape = table3.shape();                                  // <------ shape() is behavior of object table3
        System.out.println("shape = " + shape + " of table " + table3);
    }
}

class Table {                               // <------ Class is a blue print of Object
    int length;
    int width;                              // <------ Attributes, Field, Variable
    int height;

    Table(int l, int w, int h) {            // <------ Constructor
        length = l;
        width = w;
        height = h;
    }

    int area() {                            // <------ Behaviors, Function, Method
        return length * width;
    }

    String shape() {
        return length == width ? "Square" : "Rectangle";
    }

    public String printTable() {
        return "Table{" + "length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    public String toString() {
        return "Table{" + "length=" + length + ", width=" + width + ", height=" + height + '}';
    }
}
