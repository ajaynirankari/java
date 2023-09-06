package com.gl.Java2023Session57;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {

        // Stream API
        List<Employee> employeeList = loadData();
        employeeList.forEach(System.out::println);

        String allEmpName =
                employeeList
                        .stream()
                        .map(e -> e.name())
                        .collect(Collectors.joining());

        System.out.println("allEmpName = " + allEmpName);

        String allEmpName1 =
                employeeList
                        .stream()
                        .map(e -> e.name())
                        .collect(Collectors.joining(", "));

        System.out.println("allEmpName1 = " + allEmpName1);

        System.out.println(
                employeeList
                        .stream()
                        .map(e -> e.name())
                        .collect(Collectors.joining(" - "))
        );

        System.out.println(
                employeeList
                        .stream()
                        .map(e -> e.name())
                        .collect(Collectors.joining(" - ", "{", "}"))
        );

        System.out.println(
                employeeList
                        .stream()
                        .map(Employee::name)
                        .collect(Collectors.joining(", ", "{", "}"))
        );

        System.out.println(
                employeeList
                        .stream()
                        .map(Employee::name)
                        .collect(Collectors.toSet())
        );

        System.out.println("-----------------------------------------------------------");
        List<Employee> collect = employeeList.stream()
                .filter(e -> e.name()
                        .contains("i"))
                .toList();
        collect.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");

        List<Employee> collect1 = employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::salary))
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);


        Optional<Employee> optionalEmployeeMax = employeeList.stream()
                .filter(e -> e.age() > 9)
                .max(Comparator.comparing(Employee::salary));


        if (optionalEmployeeMax.isPresent()) {
            Employee employee = optionalEmployeeMax.get();
            System.out.println("optionalEmployeeMax = " + employee);
        } else {
            System.out.println("NO Data, The optionalEmployeeMax = " + optionalEmployeeMax);
        }

        Optional<Employee> optionalEmployeeMin = employeeList.stream()
                .min(Comparator.comparing(Employee::salary));

        if (optionalEmployeeMin.isPresent()) {
            Employee employee1 = optionalEmployeeMin.get();
            System.out.println("optionalEmployeeMin = " + employee1);
        }


        Optional<Employee> optionalEmployeeMaxAge = employeeList.stream()
                .max(Comparator.comparing(Employee::age));

        if (optionalEmployeeMaxAge.isPresent()) {
            Employee employee1 = optionalEmployeeMaxAge.get();
            System.out.println("optionalEmployeeMaxAge = " + employee1);
        }

        Optional<Employee> optionalEmployeeMinAge = employeeList.stream()
                .min(Comparator.comparing(Employee::age));

        if (optionalEmployeeMinAge.isPresent()) {
            Employee employee1 = optionalEmployeeMinAge.get();
            System.out.println("optionalEmployeeMinAge = " + employee1);
        }

        List<Integer> integerList = List.of(6, 8, 2, 4, 1);
        List<Integer> collect2 = integerList
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);

        List<String> stringList = List.of("one", "two", "three", "four");

        List<String> list = stringList
                .stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .toList();
        System.out.println("list = " + list);


        List<Integer> list1 = Stream.iterate(1, n -> n < 30, n -> n + 3)
                .filter(n -> n % 2 != 0)
                .map(n -> n * 10)
                .toList();
        System.out.println("list1 = " + list1);

        List<Integer> list2 = IntStream.range(1, 50)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        System.out.println("list2 = " + list2);

        List<Integer> list3 = IntStream.rangeClosed(1, 50)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        System.out.println("list3 = " + list3);


    }

    static List<Employee> loadData() {
        Employee employee1 = new Employee(100, "Smith", 45, 34000, "CS", "INDIA");
        Employee employee2 = new Employee(101, "John", 32, 52000, "IT", "ENGLAND");
        Employee employee3 = new Employee(102, "Corey", 28, 36000, "IT", "USA");
        Employee employee4 = new Employee(103, "Marry", 28, 68000, "CS", "USA");
        Employee employee5 = new Employee(104, "Zenith", 45, 18000, "FIN", "USA");
        Employee employee6 = new Employee(105, "Tom", 60, 48000, "GEN", "CHINA");
        Employee employee7 = new Employee(106, "Tom", 61, 78000, "GEN", "CHINA");
        Employee employee8 = new Employee(107, "Tim", 21, 28000, "IT", "ENGLAND");
        Employee employee9 = new Employee(108, "Sumo", 29, 29000, "FIN", "JAPAN");
        Employee employee10 = new Employee(109, "Samu", 32, 9200, "CS", "JAPAN");
        Employee employee11 = new Employee(110, "Jonny", 60, 48000, "GEN", "CHINA");
        Employee employee12 = new Employee(110, "Jonny", 60, 48000, "GEN", "CHINA");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        employeeList.add(employee9);
        employeeList.add(employee10);
        employeeList.add(employee11);
        employeeList.add(employee12);

        return employeeList;
    }
}

record Employee(int id, String name, int age, int salary, String department, String city) {
}