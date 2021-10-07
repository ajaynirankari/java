package com.gl.comparingObjectsDemo;

import java.util.Objects;

public class ComparingObjectsDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        show(a == b);

        String s1 = new String("One");
        String s2 = new String("One");

        show(s1 == s2);
        show(s1.equals(s2));

        StringBuffer stringBuffer1 = new StringBuffer("One");
        StringBuffer stringBuffer2 = new StringBuffer("One");

        show(stringBuffer1 == stringBuffer2);
        show(stringBuffer1.equals(stringBuffer2));

        Emp emp1 = new Emp("Sam", 34, 11);
        Emp emp2 = new Emp("Sam", 34, 11);
        show(emp1 == emp2);
        show(emp1.equals(emp2));
        show(Objects.equals(emp1, emp2));


        Emp emp11 = new Emp("Sam", 34, 11);
        Emp emp21 = new Emp("SamN", 35, 12);
        show(emp11 == emp21);
        show(emp11.equals(emp21));
        show(Objects.equals(emp11, emp21));

        String ss1 = "One";
        String ss2 = "One";
        String ss3 = new String("One");
        String ss4 = new String("One");
        StringBuffer ss5 = new StringBuffer("One");
        show(ss1 == ss2);
        show(ss1 == ss3);
        show(ss3 == ss4);
        show(ss3.equals(ss4));
        show(ss4.equals(ss5));
    }

    static void show(boolean b) {
        System.out.println(b);
    }
}

class Emp {
    String name;
    int age;
    int id;

    public Emp(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return age == emp.age && id == emp.id && Objects.equals(name, emp.name);
        //return id == emp.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, id);
    }
}
