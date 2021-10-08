package com.gl.ComparableVsComparatorDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableVsComparatorDemo {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five");
        show(stringList);
        Collections.sort(stringList);
        show(stringList);
        List<Emp> empList = Arrays.asList(new Emp(1, "one", 45),
                new Emp(2, "two", 50),
                new Emp(5, "five", 24),
                new Emp(4, "four", 43),
                new Emp(3, "three", 30)
        );
        show(empList);

        Collections.sort(empList);
        show(empList);

        empList.sort(new NameComparator());
        show(empList);

        empList.sort(new AgeComparator());
        show(empList);

        empList.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                return o1.age - o2.age;
            }
        });
        show(empList);

        empList.sort((Emp o1, Emp o2) -> {
                    return o1.age - o2.age;
                }
        );
        show(empList);

        empList.sort((o1, o2) -> {
                    return o1.age - o2.age;
                }
        );
        show(empList);

        empList.sort((o1, o2) -> o1.age - o2.age);
        show(empList);

        empList.sort((o1, o2) -> o1.id - o2.id);
        show(empList);

        empList.sort((o1, o2) -> o1.name.compareTo(o2.name));
        show(empList);

        empList.sort(Comparator.comparing(Emp::getAge));
        show(empList);

        empList.sort(Comparator.comparing(Emp::getName));
        show(empList);
    }

    static void show(Object o) {
        System.out.println(o);
    }

}

class AgeComparator implements Comparator<Emp> {
    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.age - o2.age;
    }
}

class NameComparator implements Comparator<Emp> {
    @Override
    public int compare(Emp o1, Emp o2) {
        return o1.name.compareTo(o2.name);
    }
}

//class Emp {
class Emp implements Comparable<Emp> {
    int id;
    String name;
    int age;

    private Emp() {
    }

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Emp o) {
        return this.id - o.id;
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
        return "[" + id + ", " + name + ", " + age + "]";
    }
}