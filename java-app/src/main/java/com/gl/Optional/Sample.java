package com.gl.Optional;

import java.util.List;
import java.util.Optional;

public class Sample {
    public static void main(String[] args) {
        List<Customer> customers = getCustomers();

        String customerName = getCustomerName(customers, 101);
        System.out.println("customerName = " + customerName);

        customerName = getCustomerName(customers, 109);
        System.out.println("customerName = " + customerName);

        String data = "Data";
        Optional<String> data1 = Optional.of(data);
        System.out.println("data1 = " + data1);

        String data2 = null;
        Optional<String> data3 = Optional.of(data2);

        Optional<String> data21 = Optional.ofNullable(data2);
        System.out.println("data21 = " + data21);

        Optional<Object> empty = Optional.empty();
        System.out.println("empty = " + empty);
    }

    static String getCustomerName(List<Customer> list, int id) {
        Optional<Customer> optionalCustomer = list.stream()
                .filter(customer -> customer.id() == id)
                .findFirst();

        String name = null;

        if (optionalCustomer.isPresent()) {
            name = optionalCustomer.get().name();
        } else {
            name = "Unknown";
        }

        name = optionalCustomer.orElse(new Customer(0, "Unknown", 0)).name();

        Optional<String> optionalName = list
                .stream()
                .filter(customer -> customer.id() == id)
                .findFirst()
                .map(Customer::name)
                .filter(s -> s.length() > 3);

        name = optionalName.orElse("Unknown");

        return name;
    }

    static List<Customer> getCustomers() {
        List<Customer> customers = List.of(new Customer(101, "John", 45),
                new Customer(102, "Mike", 55),
                new Customer(103, "Tim", 40),
                new Customer(104, "Mary", 50),
                new Customer(105, "Smith", 51)
        );
        return customers;
    }
}

record Customer(int id, String name, int age) {
}