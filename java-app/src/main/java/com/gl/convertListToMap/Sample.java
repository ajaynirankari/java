package com.gl.convertListToMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        List<Student> students = List.of(new Student(1, "one"), new Student(2, "two"), new Student(3, "three"), new Student(4, "four"), new Student(5, "five"));
        System.out.println("List of students = " + students);

        Map<Integer, Student> mapOfIdToStudent = students.stream().collect(Collectors.toMap(Student::id, student -> student, (oldValue, newValue) -> newValue));
        System.out.println("Map of students = " + mapOfIdToStudent);
    }
}

record Student(
        int id,
        String name) {
}