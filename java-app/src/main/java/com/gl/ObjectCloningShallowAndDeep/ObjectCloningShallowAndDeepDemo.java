package com.gl.ObjectCloningShallowAndDeep;

public class ObjectCloningShallowAndDeepDemo {
    public static void main(String[] args) throws Exception {

        Address address1 = new Address("North Site", "Delhi");
        User user1 = new User(101, "Deepak", address1);
        System.out.println("User1 = " + user1);

        User user2 = user1.clone();
        System.out.println("User2 = " + user2);

        address1.setCity("East Site");

        System.out.println("User1 = " + user1);
        System.out.println("User2 = " + user2);

        User user3 = new User(user1);
        System.out.println("User3 = " + user3);

    }
}

class User implements Cloneable {

    User(User that) {
        this.id = that.id;
        that.name = that.name;
        this.address = new Address(that.address);
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();
        clone.address = this.address.clone();
        return clone;
    }

    int id;
    String name;
    Address address;

    public User(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable {

    Address(Address that) {
        this.city = that.city;
        this.state = that.state;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}