package com.gl.Java2023Session53;

import com.gl.util.Data;
import com.gl.util.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        List<Student> studentList = Data.getStudents();
        studentList.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Student> stringListGT50 = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            int age = student.getAge();
            if (age > 50) {
                stringListGT50.add(student);
            }
        }
        System.out.println("---------------------------------------------------");

        stringListGT50.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Student> studentListGT50_1 = studentList.stream()
                .filter(s -> s.getAge() > 50)
                .toList();
        studentListGT50_1.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Student> collect1 = studentList.stream()
                .filter(s -> s.getName()
                        .endsWith("m"))
                .collect(Collectors.toList());

        collect1.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .filter(s -> s.getName()
                        .startsWith("J"))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .sorted(Comparator.comparing(Student::getAge)
                        .thenComparing(Student::getName))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .sorted(Comparator.comparing(Student::getAge)
                        .reversed())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .sorted(Comparator.comparing(Student::getPhone))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .map(s -> s.getName()
                        .toUpperCase())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<String> list = studentList.stream()
                .map(s -> s.getName())
                .toList();
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Student> list1 = studentList.stream()
                .map(s -> new Student(s.getRollNo(), s.getName()
                        .toUpperCase(), s.getAge(), s.getPhone(), s.getMarks()))
                .toList();
        list1.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .map(s -> new Student(s.getRollNo(), s.getName()
                        .toUpperCase(), s.getAge(), s.getPhone(), s.getMarks()))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .map(s -> s.getMarks())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .map(s -> s.getMarks()
                        .values())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .map(s -> s.getMarks()
                        .values()
                        .stream()
                        .reduce(0, (a, b) -> a + b))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        Integer topper = studentList.stream()
                .map(s -> s.getMarks()
                        .values()
                        .stream()
                        .reduce(0, Integer::sum))
                .max(Integer::compareTo)
                .get();
        System.out.println("topper Max mark = " + topper);
        System.out.println("---------------------------------------------------");

        Integer lower = studentList.stream()
                .map(s -> s.getMarks()
                        .values()
                        .stream()
                        .reduce(0, Integer::sum))
                .min(Integer::compareTo)
                .get();
        System.out.println("Min mark = " + lower);
        System.out.println("---------------------------------------------------");

        studentList.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        studentList.stream()
                .filter(s -> s.getName()
                        .equals("Marry"))
                .toList()
                .stream()
                .map(e -> e.getMarks()
                        .get("History"))
                .forEach(System.out::println);

    }

}
