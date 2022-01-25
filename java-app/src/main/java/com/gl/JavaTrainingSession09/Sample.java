package com.gl.JavaTrainingSession09;

public class Sample {
    public static void main(String[] args) {

        Person person = new Person("Mary", "marry.gail.com", 34000, 45);
        System.out.println("person = " + person);
        //person.age=99999;
        person.setAge(50);
        System.out.println("person = " + person);
        System.out.println("person.getAge() = " + person.getAge());

        String str = person.toString();
        System.out.println("str = " + str);

        int hashCode = person.hashCode();
        System.out.println("hashCode = " + hashCode);

        Emp e = new Emp();
        e.age = 9000;
    }
}

class Person {
    private String name;
    private String email;
    private int salary;
    private int age;

    public void setAge(int age) {
        if (age > 18 && age < 60) {
            this.age = age;
        } else {
            throw new RuntimeException("Age can not be > 60");
        }
    }

    public int getAge() {
        return age;
    }

    public Person(String name, String email, int salary, int age) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }
}

class Emp {
    String name;
    int age;
}
