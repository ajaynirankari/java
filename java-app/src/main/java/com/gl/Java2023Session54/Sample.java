package com.gl.Java2023Session54;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Sample {
    public static void main(String[] args) {

        // Stream API
        // Collector API

        Employee employee1 = new Employee(100, "Smith", 45, 34000, "CS", "Delhi");
        Employee employee2 = new Employee(101, "John", 32, 52000, "IT", "Dhaka");
        Employee employee3 = new Employee(102, "Corey", 28, 36000, "IT", "USA");
        Employee employee4 = new Employee(103, "Marry", 28, 68000, "CS", "USA");
        Employee employee5 = new Employee(104, "Zenith", 45, 18000, "FIN", "USA");
        Employee employee6 = new Employee(105, "Tom", 60, 48000, "GEN", "CHINA");
        Employee employee7 = new Employee(106, "Tom", 61, 78000, "GEN", "CHINA");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);


        employeeList.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");


        List<Employee> employeeListOfUSA = employeeList.stream()
                .filter(e -> e.city()
                        .equals("USA"))
                .toList();

        employeeListOfUSA.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");

        List<String> employeeNameOfUSA = employeeList.stream()
                .filter(e -> e.city()
                        .equals("USA"))
                .map(e -> e.name())
                .toList();
        employeeNameOfUSA.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");


        Map<String, List<Employee>> cityMap =
                employeeList.stream()
                        .collect(groupingBy(Employee::city));
        System.out.println("cityMap = " + cityMap);

        for (var cityName : cityMap.keySet()) {
            List<Employee> employeeList1 = cityMap.get(cityName);
            System.out.println(cityName + " -->  " + employeeList1);
        }
        System.out.println("-----------------------------------------------------------");

        Map<String, Long> collectByCityName = employeeList.stream()
                .collect(groupingBy(Employee::city, counting()));

        for (var cityName : collectByCityName.keySet()) {
            System.out.println(cityName + " -->  " + collectByCityName.get(cityName));
        }

        System.out.println("-----------------------------------------------------------");

        Map<String, List<String>> collectByCityWithEMpName = employeeList.stream()
                .collect(groupingBy(Employee::city, mapping(Employee::name, toList())));

        for (var cityName : collectByCityWithEMpName.keySet()) {
            System.out.println(cityName + " -->  " + collectByCityWithEMpName.get(cityName));
        }


        System.out.println("-----------------------------------------------------------");

        Map<String, List<String>> collectByDepartmentWithEMpName = employeeList.stream()
                .collect(groupingBy(Employee::department, mapping(Employee::name, toList())));

        for (var cityName : collectByDepartmentWithEMpName.keySet()) {
            System.out.println(cityName + " -->  " + collectByDepartmentWithEMpName.get(cityName));
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("collectByDepartmentWithEMpName = " + collectByDepartmentWithEMpName);
        System.out.println("-----------------------------------------------------------");


        Map<String, List<String>> collectByCityWithEMpName1 = employeeList.stream()
                .collect(groupingBy(Employee::city, filtering(e -> e.city()
                        .equals("USA"), mapping(Employee::name, toList()))));

        for (var cityName : collectByCityWithEMpName1.keySet()) {
            System.out.println(cityName + " -->  " + collectByCityWithEMpName1.get(cityName));
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println(

                employeeList.stream()
                        .collect(groupingBy(Employee::city, filtering(e -> e.city()
                                .equals("USA"), toList())))
        );

        System.out.println("-----------------------------------------------------------");
        Map<String, List<String>> collectByCityWithEMpName2 = employeeList
                .stream()
                .filter(e -> e.city()
                        .equals("USA"))
                .collect(groupingBy(Employee::city, mapping(Employee::name, toList())));

        for (var cityName : collectByCityWithEMpName2.keySet()) {
            System.out.println(cityName + " -->  " + collectByCityWithEMpName2.get(cityName));
        }
        System.out.println("-----------------------------------------------------------");

        Map<String, List<String>> collectByCityWithEMpName3 = employeeList
                .stream()
                //.filter(e-> e.city().equals("USA"))
                .collect(groupingBy(Employee::city, filtering(e -> e.city()
                        .equals("USA"), mapping(Employee::name, toList()))));

        for (var cityName : collectByCityWithEMpName3.keySet()) {
            System.out.println(cityName + " -->  " + collectByCityWithEMpName2.get(cityName));
        }
        System.out.println("-----------------------------------------------------------");


        Map<Integer, List<Employee>> collect = employeeList.stream()
                .collect(groupingBy(Employee::id));
        System.out.println("-----------------------------------------------------------");

        List<Integer> collect3 = employeeList.stream()
                .map(Employee::id)
                .collect(toList());
        System.out.println("collect3 = " + collect3);
        System.out.println("-----------------------------------------------------------");

        Set<Integer> collect1 = employeeList.stream()
                .map(Employee::id)
                .collect(toSet());
        System.out.println("collect1 = " + collect1);
        System.out.println("-----------------------------------------------------------");

        List<Integer> integers = List.of(1, 2, 3, 4, 56);
        Map<Integer, Integer> collect2 = integers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(toMap(Function.identity(), e -> e));
        System.out.println("collect2 = " + collect2);
        System.out.println("-----------------------------------------------------------");
    }
}

record Employee(int id, String name, int age, int salary, String department, String city) {
}


