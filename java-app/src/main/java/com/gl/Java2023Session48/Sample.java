package com.gl.Java2023Session48;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) {

        Collection<Integer> numbers = new HashSet<>();
        numbers.add(45);
        numbers.add(50);
        numbers.add(44);
        numbers.add(65);
        System.out.println("numbers = " + numbers);
        System.out.println("---------------------------------------------------------");

        Collection<String> names = new ArrayList<>();
        names.add("Josh");
        names.add("Patric");
        names.add("Tim");
        names.add("Adam");
        System.out.println("names = " + names);
        System.out.println("---------------------------------------------------------");

        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Josh");
        map.put(102, "Patric");
        map.put(103, "Tim");
        map.put(104, "Adam");
        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        String s = map.get(103);
        System.out.println("map.get(103) = " + s);
        System.out.println("map.put(103,Smith)");
        map.put(103, "Smith");
        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        System.out.println("map.get(103) = " + map.get(103));
        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        System.out.println("map.get(113) = " + map.get(113));


        List<String> names1 = new ArrayList<>();
        names1.add("Josh");
        names1.add("Patric");
        names1.add("Tim");
        names1.add("Adam");
        System.out.println("names1 = " + names1);
        System.out.println("---------------------------------------------------------");
        System.out.println("names1.get(0) = " + names1.get(0));
        System.out.println("names1.get(3) = " + names1.get(3));
        //System.out.println("names1.get(10) = " + names1.get(10)); Throw Exception

        Set<String> names2 = new HashSet<>();
        names2.add("Josh");
        names2.add("Patric");
        names2.add("Tim");
        names2.add("Adam");
        System.out.println("---------------------------------------------------------");
        System.out.println("Set names2 = " + names2);
        System.out.println("---------------------------------------------------------");
        System.out.println("Set names2 = " + names2.stream()
                .findFirst()
                .get());
        System.out.println("---------------------------------------------------------");

        Iterator<String> iterator = names2.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println("value = " + value);
        }
        System.out.println("---------------------------------------------------------");


        int i = 0;
        String value = null;
        Iterator<String> iterator_ = names2.iterator();
        while (iterator_.hasNext() && i < 3) {
            value = iterator_.next();
            i++;
            System.out.println("value = " + value);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("value = " + value);
        value=names2
                .stream()
                .findFirst()
                .get();

        System.out.println("value = " + value);
        System.out.println("---------------------------------------------------------");

        List<String> names3 = new ArrayList<>();
        for (int j=0;j<100000;j++){
            names3.add("UserName_"+j);
        }
        System.out.println("names3.size() = " + names3.size());
        System.out.println("---------------------------------------------------------");

        List<String> collect = IntStream.range(0, 100000)
                .boxed()
                .map(n -> "UserName_" + n)
                .toList();

        System.out.println("collect.size() = " + collect.size());
        System.out.println("---------------------------------------------------------");

        System.out.println("Integer.MAX_VALUE = "+Integer.MAX_VALUE);
        BigInteger bigInteger;

        System.out.println("map = " + map);

        map.put(99,"Value99");
        map.put(990,"Value990");
        System.out.println("map = " + map);
        map.put(99,"Value99ReplaceNewValue");

        System.out.println("---------------------------------------------------------");
        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        System.out.println("map.get(99) = " + map.get(99));
        System.out.println("map.get(909) = " + map.get(909));

        map.put(1,"one");
        map.put(2,"one");
        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        Set<Integer> allKeys = map.keySet();
        System.out.println("allKeys = " + allKeys);
        System.out.println("---------------------------------------------------------");

        Collection<String> values = map.values();
        System.out.println("values = " + values);
        System.out.println("---------------------------------------------------------");

        Iterator<Integer> iterator1 = allKeys.iterator();
        while (iterator1.hasNext()){
            Integer key = iterator1.next();
            System.out.println("key = " + key+", value = "+map.get(key));
        }
        System.out.println("---------------------------------------------------------");

        for (Integer key : allKeys) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
        System.out.println("---------------------------------------------------------");

        System.out.println("map.get(675857) = " + map.get(675857));

        System.out.println("map = " + map);
        System.out.println("---------------------------------------------------------");

        for (Integer key : map.keySet()) {
            String value1 = map.get(key);
            System.out.println("key = " + key + ", value = " + value1);
        }
        System.out.println("---------------------------------------------------------");
    }
}
