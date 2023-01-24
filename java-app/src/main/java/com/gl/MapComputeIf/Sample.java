package com.gl.MapComputeIf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Sample {
    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("one", 101);
        map.put("two", 201);
        System.out.println("map = " + map);

        map.put("one", 301);
        System.out.println("map = " + map);
        process(map);
    }

    static void process(Map<String, Integer> map) {
        map.put("one", 501);
        System.out.println("map = " + map);

        Integer one = map.get("three");
        if (one == null) {
            map.put("three", 601);
        }
        System.out.println("map = " + map);

        map.putIfAbsent("three", 701);
        System.out.println("map = " + map);

        map.computeIfAbsent("four", k -> k.length());
        System.out.println("map = " + map);

        map.computeIfAbsent("four", k -> k.length() * 100);
        System.out.println("map = " + map);

        map.computeIfAbsent("five", k -> k.length() * 100);
        System.out.println("map = " + map);

        map.computeIfPresent("five", (k, v) -> v + 1);
        System.out.println("map = " + map);

        map.computeIfPresent("five", (k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
            return v + 10;
        });
        System.out.println("map = " + map);

        map.compute("six", (k, v) -> k.length() * 11);
        System.out.println("map = " + map);

        map.compute("six", (k, v) -> k.length() * 22);
        System.out.println("map = " + map);
    }
}
