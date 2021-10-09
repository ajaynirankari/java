package com.gl.recorddemo;

import java.io.Serializable;
import java.util.Objects;

public class RecordDemo {
    public static void main(String[] args) {
        Student student = new Student(100, "Sam", 35);
        System.out.println(student.getName());
        System.out.println(student);

        Employee employee = new Employee(200, "Paul", 28);
        System.out.println(employee.name());
        System.out.println(employee);

        System.out.println(employee.getNameWithAge());
        Employee employee1 = new Employee(300, "John", 15);
        System.out.println(employee1);

        Employee employee2 = new Employee(300, null, 15);
        System.out.println(employee2);

        Location location = new Location("Delhi", "India");
        System.out.println(location);

        java.lang.Record record;
    }
}

record Location(String city, String country) {
}

record Employee(int id, String name, int age) implements Serializable, Comparable<Employee> {

    Employee {
        Objects.requireNonNull(name);
        if (age < 18) throw new RuntimeException("Age can not be < 18");
    }

    public String getNameWithAge() {
        return name + " with age: " + age;
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}

class Student {
    private int id;
    private String name;
    private int age;

    private Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}