package com.gl.EncapsulationRecordClassesDemo;

public class EncapsulationRecordClassesDemo {
    public static void main(String[] args) {
        Employee employee = new Employee(101, "Sam", 40, 5600);
        System.out.println(employee);
        //employee.age = 8000;
        System.out.println(employee);
        employee.setAge(9000);

        System.out.println(employee);

        Emp emp = new Emp(200, "Paul", 34, 56000);
        System.out.println(emp);
        System.out.println(emp.age());

        Emp emp1 = new Emp(200, "Paul", 5000, 56000);
        System.out.println(emp1);
        System.out.println(emp1.age());

    }
}

record Emp(int code, String name, int age, int salary) {
    Emp {
        if (!(age > 18 && age < 60)) {
            throw new RuntimeException("Can not create Emp with such age value = "+age);
        }
    }
}

class Employee {
    private int code;
    private String name;
    private int age;
    private int salary;

    private Employee() {
    }

    public Employee(int code, String name, int age, int salary) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
        if (age > 18 && age < 60)
            this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

