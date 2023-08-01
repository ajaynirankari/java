package com.gl.Java2023Session34;

public class Sample {
    public static void main(String[] args) {

        Child child = new Child("Smith", "10th");
        System.out.println("child.getProperties() = " + child.getProperties());
        System.out.println("child.getQualification() = " + child.getQualification());

        Parent parent = new Parent("John", "B.Tech");
        System.out.println("parent.getProperties() = " + parent.getProperties());
        System.out.println("parent.getQualification() = " + parent.getQualification());

        Test test = new Test();
        System.out.println("test.toString() = " + test.toString());
        System.out.println("test.hashCode() = " + test.hashCode());
    }
}

class GrandParent {
    GrandParent(String name) {
        super();                // ---> Create the object of super class - Object
        System.out.println(" ------ GrandParent constructor called -----");
    }
}

class Parent extends GrandParent {
    private String name;
    private String qualification;
    private String properties = "House";

    Parent(String n, String q) {
        super("GrandParentName"); // ---> Create the object of super class - GrandParent
        System.out.println(" ------ Parent constructor called -----");
        name = n;
        qualification = q;

    }

    public String getProperties() {
        return properties;
    }

    public String getQualification() {
        return qualification;
    }
}

class Child extends Parent {
    private String name;
    private String qualification;

    Child(String n, String q) {
        super("PName", "PQualification"); // ---> Create the object of super class - Parent
        System.out.println(" ------ Child constructor called -----");
        name = n;
        qualification = q;
    }

    public String getQualification() {
        return qualification;
    }
}

class Test {
}