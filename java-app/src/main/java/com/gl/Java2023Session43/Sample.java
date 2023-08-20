package com.gl.Java2023Session43;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {

        int a1 = 10;
        int a2 = 20;
        int a3 = 30;
        int a4 = 40;

        int sum = a1 + a2 + a3 + a4;
        System.out.println("sum = " + sum);
        System.out.println("--------------------------------------------------");

        int[] numbers = new int[4];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        int sum1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum1 = sum1 + numbers[i];
        }
        System.out.println("sum1 = " + sum1);
        System.out.println("--------------------------------------------------");

        int[] numbers1 = {10, 20, 30, 40};
        System.out.println("------------- numbers1 = " + numbers1);
        int sum2 = 0;
        for (int n : numbers) {
            sum2 = sum2 + n;
        }
        System.out.println("sum2 = " + sum2);
        System.out.println("--------------------------------------------------");

        Employee[] employees = new Employee[3];
        employees[0] = new Employee(101, "Sam");
        employees[1] = new Employee(102, "Jos");
        employees[2] = new Employee(103, "Tim");
        for (Employee e : employees) {
            System.out.println(e);
        }
        //employees[3] = new Employee(104, "Jam");
        System.out.println("--------------------------------------------------");

        // Java Collection Framework or API

        List<Integer> integers = List.of(1, 2, 4, 6, 8, 8, 9);
        System.out.println("----------- integers = " + integers);
        for (int e : integers) {
            System.out.println("e = " + e);
        }
        System.out.println("--------------------------------------------------");

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(3);
        integers1.add(6);
        integers1.add(8);
        integers1.add(8);
        System.out.println("integers1 = " + integers1);
        integers1.add(98);
        System.out.println("integers1 = " + integers1);
        integers1.remove(2);
        System.out.println("integers1 = " + integers1);
        System.out.println("--------------------------------------------------");

        List<Integer> collection1 = new ArrayList<>();
        System.out.println("collection1 = " + collection1 + ", size = " + collection1.size());
        collection1.add(34);
        System.out.println("collection1 = " + collection1 + ", size = " + collection1.size());
        collection1.add(47);
        System.out.println("collection1 = " + collection1 + ", size = " + collection1.size());
        collection1.add(7);
        collection1.add(4);
        collection1.add(74);
        System.out.println("collection1 = " + collection1 + ", size = " + collection1.size());
        collection1.remove(2);
        System.out.println("collection1 = " + collection1 + ", size = " + collection1.size());
        System.out.println("--------------------------------------------------");


        ArrayList<Integer> integers2 = new ArrayList<>(List.of(4, 6, 8, 2));
        System.out.println("integers2 = " + integers2);
        integers2.add(55);
        System.out.println("integers2 = " + integers2);
        System.out.println("--------------------------------------------------");

        // List is an interface, ArrayList is an implementation class

        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(45);
        System.out.println("--------------------------------------------------");

        List<Double> doubles = new ArrayList<>();
        doubles.add(5.6);
        doubles.add(3.6);
        doubles.add(6.0);
        doubles.add(5.0);
        System.out.println("doubles = " + doubles);
        System.out.println("--------------------------------------------------");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Sam"));
        employeeList.add(new Employee(112, "Mac"));
        employeeList.add(new Employee(113, "Jos"));
        employeeList.add(new Employee(114, "Tim"));
        System.out.println("employeeList = " + employeeList);
        System.out.println("--------------------------------------------------");

        List<Integer> num1 = new ArrayList<>();
        num1.add(12);
        num1.add(14);
        num1.add(12);
        num1.add(15);
        System.out.println("num1 = " + num1);
        System.out.println("--------------------------------------------------");

        List<Integer> num11 = List.of(11, 12, 12, 14, 15);
        System.out.println("num11 = " + num11);
        //num11.add(56);
        System.out.println("--------------------------------------------------");

        Set<Integer> num2 = new HashSet<>();
        System.out.println(num2.add(12));
        System.out.println(num2.add(14));
        System.out.println(num2.add(12));
        System.out.println(num2.add(15));
        System.out.println("num2 = " + num2);
        System.out.println("--------------------------------------------------");

        Set<Integer> num22 = Set.of(12, 14, 15);
        System.out.println("num22 = " + num22);
        System.out.println("--------------------------------------------------");
    }
}

record Employee(int eid, String name) {
}
