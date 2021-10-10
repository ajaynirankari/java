package com.gl.SerializableDemo;

import java.io.*;
import java.util.Objects;

public class SerializableDemo {
    public static void main(String[] args) throws Exception {
        var employee = new Employee(100, "Sam", 35, new Address("New York", "US"));
        System.out.println(employee.getName());
        System.out.println(employee);

        objectSerialize(employee);

        var employeeN = (Employee) objectDeserialize();

        System.out.println(employeeN.getName());
        System.out.println(employeeN);

        var student = new Student(101, "John", 24);
        System.out.println(student);
        objectSerialize(student);

        var student1 = (Student) objectDeserialize();
        System.out.println(student1);

        B b = new B(55);
        System.out.println(b);
        objectSerialize(b);

        B b1 = (B) objectDeserialize();
        System.out.println(b1);
    }

    private static Object objectDeserialize() throws IOException, ClassNotFoundException {
        try (var ois = new ObjectInputStream(new FileInputStream("ser.data"))) {
            return ois.readObject();
        }
    }

    private static void objectSerialize(Object object) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream("ser.data"))) {
            oos.writeObject(object);
        }
    }
}

class A implements Serializable {
    int a;

    A() {
    }

    A(int a) {
        this.a = a * 100;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}

class B extends A {
    int b;

    B() {
        super();
    }

    B(int b) {
        super(b);
        this.b = b;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

record Student(int id, String name, int age) implements Serializable {
}

class Employee implements Serializable {
    private int id;
    private String name;
    private int age;
    private Address address;

    public Employee() {
    }

    public Employee(int id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class Address implements Serializable {
    private String city;
    private String country;

    public Address() {
    }

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}