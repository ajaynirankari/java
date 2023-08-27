package com.gl.Java2023Session50;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight");
        System.out.println("list = " + list);

        Collections.sort(list);                     // Natural order
        System.out.println("list by Natural order = " + list);

        Collections.sort(list, Collections.reverseOrder());  // Reverse order
        System.out.println("list by Reverse order = " + list);
        System.out.println("--------------------------------------------------------------------------");

        List<Integer> list1 = Arrays.asList(7, 3, 9, 1, 8, 2);
        System.out.println("list1 = " + list1);

        Collections.sort(list1);
        System.out.println("list1 by Natural order = " + list1);

        Collections.sort(list1, Collections.reverseOrder());
        System.out.println("list1 by Reverse order= " + list1);
        System.out.println("--------------------------------------------------------------------------");

        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "Josh", 45),
                new Employee(405, "Tim", 27),
                new Employee(19, "Smith", 74)
        );

        System.out.println("employeeList = " + employeeList);

        Collections.sort(employeeList);                   // Natural order
        System.out.println("employeeList by Id = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        class AgeComparator implements Comparator<Employee> {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge();
            }
        }
        Collections.sort(employeeList, new AgeComparator());
        System.out.println("employeeList by Age = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName()
                        .compareTo(o2.getName());
            }
        };
        Collections.sort(employeeList, nameComparator);
        System.out.println("employeeList by Name = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        Comparator<Employee> nameLambdaComparator = (Employee o1, Employee o2) -> {
            return o1.getName()
                    .compareTo(o2.getName());
        };
        Collections.sort(employeeList, nameLambdaComparator);
        System.out.println("employeeList by Name = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        Comparator<Employee> nameLambdaComparator1 = (o1, o2) -> o1.getName()
                .compareTo(o2.getName());
        Collections.sort(employeeList, nameLambdaComparator1);
        System.out.println("employeeList by Name = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        Comparator<Employee> nameComparatorMethodReference = Comparator.comparing(Employee::getName);
        Collections.sort(employeeList, nameComparatorMethodReference);
        System.out.println("employeeList by Name = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        Collections.sort(employeeList, Comparator.comparing(Employee::getName));
        System.out.println("employeeList by Name = " + employeeList);

        Collections.sort(employeeList, Comparator.comparing(Employee::getAge));
        System.out.println("employeeList by Age = " + employeeList);

        Collections.sort(employeeList, Comparator.comparing(Employee::getId));
        System.out.println("employeeList by Id = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("employeeList = " + employeeList);
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getId() - o2.getId();
            }
        });
        System.out.println("employeeList by Id = " + employeeList);

        employeeList.sort(Comparator.comparing(Employee::getAge));
        System.out.println("employeeList by Age = " + employeeList);
        System.out.println("--------------------------------------------------------------------------");

        List<Employee> employeeListOf = List.of(
                new Employee(101, "Josh", 45),
                new Employee(405, "Tim", 27),
                new Employee(19, "Smith", 74)
        );
        System.out.println("before employeeListOf = " + employeeListOf);
        System.out.println("--------------------------------------------------------------------------");
        //employeeListOf.sort(Comparator.comparing(Employee::getAge)); Not allow to modify the original list

        List<Employee> sortedById = employeeListOf.stream()
                .sorted()
                .toList();
        System.out.println("sortedById = " + sortedById);
        System.out.println("--------------------------------------------------------------------------");

        List<Employee> sortedByAge = employeeListOf.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
        System.out.println("sortedByAge = " + sortedByAge);
        System.out.println("--------------------------------------------------------------------------");

        List<Employee> sortedByName = employeeListOf.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();
        System.out.println("sortedByName = " + sortedByName);
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("after employeeListOf = " + employeeListOf);
        System.out.println("--------------------------------------------------------------------------");

        List<Department> departmentList = Arrays.asList(
                new Department(11, "CS"),
                new Department(21, "IT"),
                new Department(10, "FINANCE"));
        System.out.println("departmentList = " + departmentList);
        System.out.println("--------------------------------------------------------------------------");

        Collections.sort(departmentList, Comparator.comparing(Department::getName));
        System.out.println("departmentList by Name = " + departmentList);
        System.out.println("--------------------------------------------------------------------------");

        departmentList.sort(Comparator.comparing(Department::getId));
        System.out.println("departmentList by Id = " + departmentList);
        System.out.println("--------------------------------------------------------------------------");

        List<Department> departmentList1 = departmentList.stream()
                .sorted(Comparator.comparing(Department::getId))
                .toList();
        System.out.println("departmentList1 = " + departmentList1);
        System.out.println("--------------------------------------------------------------------------");

        List<Department> list2 = departmentList.stream()
                .sorted(new Comparator<Department>() {
                    @Override
                    public int compare(Department o1, Department o2) {
                        return o1.getId() - o2.getId();
                    }
                })
                .toList();
        System.out.println("list2 = " + list2);
        System.out.println("--------------------------------------------------------------------------");

        List<Department> list3 = departmentList.stream()
                //.sorted()     Not allow to sort Department, because Department is NOT implement the Comparable interface
                .toList();
        System.out.println("list3 = " + list3);

        // Comparator<T> ----> int compare(T o1, T o2)  ------> Customer order, by Id, by Name, By Age
        // Comparable<T> ----> int compareTo(T o)        ------> Natural Order - only one field
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        // This method is called by sort method
        //System.out.println("Emp1 = " + this + " -------------- Emp2 = " + employee);
        return this.id - employee.id;
    }
}
