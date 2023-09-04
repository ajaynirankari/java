package com.gl.Java2023Session55;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Sample {
    public static void main(String[] args) {

        // Stream and Collector API
        // Stream is an interface
        // Collector is an interface

        List<Employee> employeeList = loadData();

        employeeList.forEach(System.out::println);

        Stream<Employee> stream = employeeList.stream();

        // Stream API or Stream interface

        stream
                .filter(e -> e.getAge() < 50)
                .map(Employee::getName)
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Employee> collect = employeeList
                .stream()
                .filter(e -> e.getAge() > 50)
                .collect(Collectors.toList());
        // toList, toSet, toMap
        collect.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        Set<Employee> collect1 = employeeList
                .stream()
                .filter(e -> e.getAge() > 50)
                .collect(Collectors.toSet());
        collect1.forEach(System.out::println);
        System.out.println("---------------------------------------------------");


        Set<String> collect2 = Stream.of("one", "two", "one")
                .collect(Collectors.toSet());
        System.out.println("collect2 = " + collect2);

        List<String> collect3 = Stream.of("one", "two", "one")
                .collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

        List<String> collect31 = Stream.of("one", "two", "one")
                .toList();
        System.out.println("collect4 = " + collect31);
        System.out.println("---------------------------------------------------");


        Map<Integer, String> collect4 = employeeList.stream()
                .collect(toMap(Employee::getId, Employee::getName));

        for (var key : collect4.keySet()) {
            System.out.println(key + " ----> " + collect4.get(key));
        }
        System.out.println("---------------------------------------------------");

        Map<String, Integer> collect5 = employeeList.stream()
                .collect(toMap(Employee::getName, Employee::getAge, (oldValue, newValue) -> oldValue));

        for (var key : collect5.keySet()) {
            System.out.println(key + " ----> " + collect5.get(key));
        }
        System.out.println("---------------------------------------------------");


        Map<String, Employee> collect6 = employeeList.stream()
                .collect(toMap(Employee::getName, e -> e, (oldValue, newValue) -> newValue));

        for (var key : collect6.keySet()) {
            System.out.println(key + " ----> " + collect6.get(key));
        }
        System.out.println("---------------------------------------------------");

        Long collect7 = employeeList.stream()
                .filter(e -> e.getAge() > 40)
                .collect(Collectors.counting());
        System.out.println("collect7 = " + collect7);
        System.out.println("---------------------------------------------------");

        long count = employeeList.stream()
                .filter(e -> e.getAge() > 40)
                .count();
        System.out.println("count = " + count);
        System.out.println("---------------------------------------------------");

        Optional<Employee> collect8 = employeeList.stream()
                .filter(e -> e.getAge() > 80)
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println("collect8 = " + collect8);
        if (collect8.isPresent()) {
            System.out.println("--------- collect8 = " + collect8.get());
        }
        System.out.println("---------------------------------------------------");

        Optional<Employee> collect9 = employeeList.stream()
                .filter(e -> e.getAge() > 18)
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
        System.out.println("collect9 = " + collect9);
        if (collect8.isPresent()) {
            System.out.println("--------- collect9 = " + collect9.get());
        }
        System.out.println("---------------------------------------------------");

        Map<Boolean, List<Employee>> collect10 = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        for (var key : collect10.keySet()) {
            System.out.println("----------" + key + " ----> ");
            collect10.get(key)
                    .stream()
                    .forEach(System.out::println);
        }
        System.out.println("---------------------------------------------------");

        Stream.iterate(1, n -> n < 50, n -> n + 1)
                .forEach(n -> System.out.print(n + ","));
        System.out.println("\n---------------------------------------------------");

        Map<Boolean, List<Integer>> collect11 = Stream.iterate(1, n -> n < 50, n -> n + 1)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        for (var key : collect11.keySet()) {
            System.out.println(key + " ----> " + collect11.get(key));
        }
        System.out.println("---------------------------------------------------");

        //employeeList.stream()
        //.filter()
        //.map()
        //.reduce()
        //.collect(new CollectorImplementationClassObject());

        // stream.collect() is a terminal operation
        // which take input as a collector interface object
        // Collector API or Collector interface
        // Collectors is a utility class thats provide the implementation of collector interface


//        employeeList
//                .stream()
//                .collect(new Collector<Employee, Object, Object>() {
//
//                    @Override
//                    public Supplier<Object> supplier() {
//                        return null;
//                    }
//
//                    @Override
//                    public BiConsumer<Object, Employee> accumulator() {
//                        return null;
//                    }
//
//                    @Override
//                    public BinaryOperator<Object> combiner() {
//                        return null;
//                    }
//
//                    @Override
//                    public Function<Object, Object> finisher() {
//                        return null;
//                    }
//
//                    @Override
//                    public Set<Characteristics> characteristics() {
//                        return null;
//                    }
//                });

        employeeList
                .stream()
                .collect(Collectors.toList());
        employeeList
                .stream()
                .collect(Collectors.toSet());

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

        return employeeList;
    }
}

record Employee1(int id, String name, int age, int salary, String department, String city) {
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    int age;
    int salary;
    String department;
    String city;

    public Employee(int id, String name, int age, int salary, String department, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.city = city;
    }

    @Override
    public int compareTo(Employee o) {
        System.out.println("--------------- o = " + o);
        return this.getAge() - o.getAge();
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class CollectorImplementationClassObject implements Collector {

    @Override
    public Supplier supplier() {
        return null;
    }

    @Override
    public BiConsumer accumulator() {
        return null;
    }

    @Override
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    public Function finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}