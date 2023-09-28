package com.gl.Java2023Session68;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;

public class Sample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // How we can write Object into file ?

        // Byte Stream
        InputStream inputStream;
        OutputStream outputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        // Character Stream
        Reader reader;
        Writer writer;

        // Object Stream File IO system
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;

        // Example
        String fileName = "objData";
        Employee employee = new Employee("Josh", 56);

        writeObjectIntoFile(fileName, employee);
        readObjectFromFile(fileName);

        List<Employee> listOfEmp = List.of(
                new Employee("Smith", 34),
                new Employee("Ken", 45),
                new Employee("Time", 67),
                new Employee("Marry", 27)
        );

        writeListOfObjectsIntoFile("listOfEmp", listOfEmp);
        readListOfObjectsFromFile("listOfEmp");

        System.out.println("Main completed ...");

    }

    private static void writeObjectIntoFile(String fileName, Employee employee) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));

        String string = "Hello";
        objectOutputStream.writeInt(12345);
        objectOutputStream.writeObject(string);
        objectOutputStream.writeObject(employee);
        objectOutputStream.close();
    }

    private static void readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

        int readInt = objectInputStream.readInt();
        System.out.println("readInt = " + readInt);

        String readStringObject = (String) objectInputStream.readObject();
        System.out.println("String readStringObject = " + readStringObject);

        Employee readEmployeeObject = (Employee) objectInputStream.readObject();
        System.out.println("Employee readEmployeeObject = " + readEmployeeObject);
    }

    private static void writeListOfObjectsIntoFile(String fileName, List<Employee> employees) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));

        objectOutputStream.writeObject(employees);
        objectOutputStream.close();
    }

    private static void readListOfObjectsFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));

        Object objects = objectInputStream.readObject();
        System.out.println("list of Employees = " + objects);

        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(fileName));

        List<Employee> employees = (List<Employee>) objectInputStream1.readObject();
        employees.stream()
                .forEach(System.out::println);
    }
}

class Employee implements Serializable {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
