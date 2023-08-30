package com.gl.Java2023Session52;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        List<Student> listOfStudents = getData();

        System.out.println("listOfStudents.size() = " + listOfStudents.size());
        System.out.println("------------------------------------------------------------");

        ArrayList<String> allNames = new ArrayList<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            Student student = listOfStudents.get(i);
            String name = student.getName();
            String upperCase = name.toUpperCase();
            allNames.add(upperCase);
        }
        System.out.println("allNames = " + allNames);
        System.out.println("------------------------------------------------------------");

        System.out.println(
                listOfStudents.stream()
                        .map(Student::getName)
                        .map(String::toUpperCase)
                        .toList()
        );
        System.out.println("------------------------------------------------------------");

        List<String> stringList = listOfStudents.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .toList();
        System.out.println("allNames = " + stringList);
        System.out.println("------------------------------------------------------------");

        System.out.println(
                listOfStudents.stream()
                        .map(Student::getName)
                        .filter(name -> name.length() > 3)
                        .map(String::toUpperCase)
                        .toList()
        );


        System.out.println(
                listOfStudents.stream()
                        .map(Student::getAge)
                        .toList()
        );
        System.out.println("------------------------------------------------------------");

        listOfStudents.stream()
                .map(student -> "{Name:" + student.getName() + ", Age:" + student.getAge() + "}")
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------------");

        listOfStudents.stream()
                .map(student -> {
                    String name = student.getName();
                    int age = student.getAge();
                    return name + " " + age;
                })
                //.map(Student::getName)
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------------");

        listOfStudents.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(s -> System.out.println(s.getName() + " " + s.getAge()));
        System.out.println("------------------------------------------------------------");

        listOfStudents.stream()
                .sorted(Comparator.comparing(Student::getAge)
                        .reversed())
                .forEach(s -> System.out.println(s.getName() + " " + s.getAge()));
        System.out.println("------------------------------------------------------------");

        Optional<Student> optionalStudent = listOfStudents.stream()
                .sorted(Comparator.comparing(Student::getAge)
                        .reversed())
                .findFirst();

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println(student.getName() + " " + student.getAge());
        }
        System.out.println("------------------------------------------------------------");

        Optional<Student> optionalStudent1 = listOfStudents.stream()
                .filter(s -> s.getAge() > 90)
                .sorted(Comparator.comparing(Student::getAge)
                        .reversed())
                .findFirst();

        if (optionalStudent1.isPresent()) {
            Student student = optionalStudent1.get();
            System.out.println(student.getName() + " " + student.getAge());
        } else {
            System.out.println("NO Data, optionalStudent1 = " + optionalStudent1);
        }

    }

    static List<Student> getData() {
        ArrayList<Student> listOfStudents = new ArrayList<>();

        Student student1 = new Student();
        student1.setRollNo(101);
        student1.setName("Smith");
        student1.setAge(34);
        student1.setPhone(1234455);
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Eng", 46);
        marks.put("Math", 56);
        marks.put("GK", 61);
        marks.put("History", 77);
        student1.setMarks(marks);

        listOfStudents.add(student1);

        Student student2 = new Student();
        student2.setRollNo(102);
        student2.setName("Tim");
        student2.setAge(43);
        student2.setPhone(3334455);
        Map<String, Integer> marks2 = new HashMap<>();
        marks2.put("Eng", 64);
        marks2.put("Math", 67);
        marks2.put("GK", 88);
        marks2.put("History", 70);
        student2.setMarks(marks2);

        listOfStudents.add(student2);

        Student student3 = new Student();
        student3.setRollNo(103);
        student3.setName("Josh");
        student3.setAge(30);
        student3.setPhone(44434455);
        Map<String, Integer> marks3 = new HashMap<>();
        marks3.put("Eng", 36);
        marks3.put("Math", 38);
        marks3.put("GK", 80);
        marks3.put("History", 37);
        student3.setMarks(marks3);

        listOfStudents.add(student3);

        Student student4 = new Student();
        student4.setRollNo(104);
        student4.setName("Josh");
        student4.setAge(34);
        student4.setPhone(66634455);
        Map<String, Integer> marks4 = new HashMap<>();
        marks4.put("Eng", 47);
        marks4.put("Math", 86);
        marks4.put("GK", 37);
        marks4.put("History", 50);
        student4.setMarks(marks4);

        listOfStudents.add(student4);

        Student student5 = new Student(105, "Cook", 87, 777898, Map.of("Eng", 56, "Math", 55, "GK", 83, "History", 59));
        listOfStudents.add(student5);

        listOfStudents.add(new Student(106, "Marry", 78, 1111898, Map.of("Eng", 68, "Math", 59, "GK", 82, "History", 58)));

        return listOfStudents;
    }
}

class Student {
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
}
