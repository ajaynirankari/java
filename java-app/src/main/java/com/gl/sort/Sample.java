package com.gl.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "John", 35);
        Employee e2 = new Employee(201, "Tim", 43);
        Employee e3 = new Employee(102, "Bob", 50);
        Employee e4 = new Employee(301, "Marry", 56);
        Employee e5 = new Employee(103, "Steve", 36);
        Employee e6 = new Employee(401, "Smith", 27);
        Employee e7 = new Employee(104, "Mike", 67);
        Employee e8 = new Employee(501, "Shreya", 45);

        Employee[] employees = {e1, e2, e3, e4, e5, e6, e7, e8};
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        sort(employees);
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees);
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        IdComparator idComparator = new IdComparator();
        Arrays.sort(employees, idComparator);
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.name().compareTo(o2.name());
            }
        });
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, (Employee o1, Employee o2) -> {
            return o1.age() - o2.age();
        });
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, (Employee o1, Employee o2) -> o1.age() - o2.age());
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, (o1, o2) -> o1.age() - o2.age());
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, Comparator.comparing(Employee::age));
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        Arrays.sort(employees, Comparator.comparing(Employee::name));
        System.out.println("Arrays.toString(employees) = " + Arrays.toString(employees));

        List<Employee> employeeList = Arrays.asList(employees);
        System.out.println("employeeList = " + employeeList);

        Collections.sort(employeeList, Comparator.comparing(Employee::name));
        System.out.println("employeeList = " + employeeList);

        employeeList.sort(Comparator.comparing(Employee::name));
        System.out.println("employeeList = " + employeeList);

        List<Employee> employeeList1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::name))
                .toList();
        System.out.println("employeeList1 = " + employeeList1);
        System.out.println("employeeList = " + employeeList);

    }

    static void sort(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees.length - i - 1; j++) {
                Employee e1 = employees[j];
                Employee e2 = employees[j + 1];
                if (e1.id() > e2.id()) {
                    employees[j] = e2;
                    employees[j + 1] = e1;
                }
            }
        }
    }
}

class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.id() - e2.id();
    }
}

record Employee(int id, String name, int age) implements Comparable<Employee> {
    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
