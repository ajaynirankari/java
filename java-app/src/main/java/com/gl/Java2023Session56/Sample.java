package com.gl.Java2023Session56;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sample {
    public static void main(String[] args) {

        // Collector API
        // Collector is an interface
        // It is not a function interface

        // 1. Use the Own Implementation class for collector interface
        // 2. Anonymous class for collector interface
        // 3. Use the existing java library, like Collectors class
        //       Collectors.toList()
        //       Collectors.toSet()
        //       Collectors.toMap()

        List<Employee> employeeList = loadData();


        List<Employee> collect = employeeList.stream()
                .filter(e -> e.department()
                        .equals("IT"))
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");

        MyOwnCollectorImplementationForToList toMyOwnList = new MyOwnCollectorImplementationForToList();

        List<Employee> collect1 = employeeList.stream()
                .filter(e -> e.department()
                        .equals("IT"))
                .collect(toMyOwnList);
        collect1.forEach(System.out::println);

        List<Employee> collect2 = employeeList.stream()
                .filter(e -> e.department()
                        .equals("IT"))
                .collect(new MyOwnCollectorImplementationForToList());
        System.out.println("-----------by Implementation class--------------------------------------------------------");
        collect2.forEach(System.out::println);


        List<Employee> collect3 = employeeList.stream()
                .filter(new Predicate<Employee>() {
                    @Override
                    public boolean test(Employee employee) {
                        return employee.department()
                                .equals("IT");
                    }
                })
                .collect(new Collector<Employee, List<Employee>, List<Employee>>() {

                    @Override
                    public Supplier<List<Employee>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<Employee>, Employee> accumulator() {
                        return List::add;
                    }

                    @Override
                    public BinaryOperator<List<Employee>> combiner() {
                        return (left, right) -> {
                            left.addAll(right);
                            return left;
                        };
                    }

                    @Override
                    public Function<List<Employee>, List<Employee>> finisher() {
                        return Function.identity();
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.IDENTITY_FINISH);
                    }
                });
        System.out.println("-----By Anonymous Class--------------------------------------------------------------");
        collect3.forEach(System.out::println);


        List<Employee> collect4 = employeeList.stream()
                .filter(new MyPredicate())
                .collect(new MyOwnCollectorImplementationForToList());
        System.out.println("-----------by Implementation class--------------------------------------------------------");
        collect4.forEach(System.out::println);

        List<Employee> collect5 = employeeList.stream()
                .filter(new MyPredicate())
                .map(new MyMapFunction())
                .collect(new MyOwnCollectorImplementationForToList());
        System.out.println("-----------by Implementation class--------------------------------------------------------");
        collect5.forEach(System.out::println);


        List<Employee> collect6 = employeeList.stream()
                .filter(e -> e.department()
                        .equals("IT"))
                .map(inputEmployee -> new Employee(inputEmployee.id(), inputEmployee.name()
                        .toUpperCase(), inputEmployee.age(), inputEmployee.salary(), inputEmployee.department(), inputEmployee.city()))
                .collect(new MyOwnCollectorImplementationForToList());
        System.out.println("-----------by Implementation class--------------------------------------------------------");
        collect6.forEach(System.out::println);


        List<Employee> collect7 = employeeList.stream()
                .filter(e -> e.department()
                        .equals("IT"))
                .map(inputEmployee -> new Employee(inputEmployee.id(), inputEmployee.name()
                        .toUpperCase(), inputEmployee.age(), inputEmployee.salary(), inputEmployee.department(), inputEmployee.city()))
                .collect(Collectors.toList());
        System.out.println("-----------by Collectors.toList()--------------------------------------------------------");
        collect7.forEach(System.out::println);


        List<Employee> collect8 = employeeList.stream()
                .filter(e -> e.age() > 50)
                .collect(Collectors.toList());
        System.out.println("-----------by Collectors.toList()--------------------------------------------------------");
        collect8.forEach(System.out::println);

        Set<Employee> collect9 = employeeList.stream()
                .filter(e -> e.age() > 50)
                .collect(Collectors.toSet());
        System.out.println("-----------by Collectors.toSet()--------------------------------------------------------");
        collect9.forEach(System.out::println);


        List<Emp> emps = List.of(
                new Emp(1, "Jay", 40),
                new Emp(2, "Mini", 40),
                new Emp(3, "Tini", 30),
                new Emp(3, "Tini", 30),
                new Emp(4, "Jaya", 30),
                new Emp(5, "Kenny", 40),
                new Emp(6, "Kenny", 18)
        );

        emps.forEach(System.out::println);

        System.out.println("----------------LIST--------------------------");
        List<Emp> collect10 = emps.stream()
                .filter(e -> e.age > 20)
                .collect(Collectors.toList());
        collect10.forEach(System.out::println);

        System.out.println("-------------------SET-----------------------");

        Set<Emp> collect11 = emps.stream()
                .filter(e -> e.age > 20)
                .collect(Collectors.toSet());
        collect11.forEach(System.out::println);
        System.out.println("------------------------------------------");

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

class Emp {
    int id;
    String name;
    int age;

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return age == emp.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MyOwnCollectorImplementationForToList implements Collector<Employee, List<Employee>, List<Employee>> {

    @Override
    public Supplier<List<Employee>> supplier() {
        return () -> new ArrayList<Employee>();
    }

    @Override
    public BiConsumer<List<Employee>, Employee> accumulator() {
        return (list, e) -> list.add(e);
    }

    @Override
    public BinaryOperator<List<Employee>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Employee>, List<Employee>> finisher() {
        return e -> e;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}

class MyPredicate implements Predicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.department()
                .equals("IT");
    }
}

class MyMapFunction implements Function<Employee, Employee> {

    @Override
    public Employee apply(Employee inputEmployee) {
        Employee outputEmployee = new Employee(inputEmployee.id(), inputEmployee.name()
                .toUpperCase(), inputEmployee.age(), inputEmployee.salary(), inputEmployee.department(), inputEmployee.city());
        return outputEmployee;
    }
}