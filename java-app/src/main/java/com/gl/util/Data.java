package com.gl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    public static List<Student> getStudents() {

        List<Student> listOfStudents = new ArrayList<>();

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
