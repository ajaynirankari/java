package com.gl.util;

import java.util.Map;

public class Student {
    private int rollNo;
    private String name;
    private int age;
    private long phone;
    private Map<String, Integer> marks;

    public Student() {
    }

    public Student(int rollNo, String name, int age, long phone, Map<String, Integer> marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", marks=" + marks +
                '}';
    }
}

