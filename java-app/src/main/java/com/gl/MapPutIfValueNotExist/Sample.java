package com.gl.MapPutIfValueNotExist;

import java.util.HashMap;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        putIfValueNotExist(map, "1", "one");
        putIfValueNotExist(map, "2", "two");
        putIfValueNotExist(map, "3", "three");
        putIfValueNotExist(map, "4", "four");
        putIfValueNotExist(map, "5", "one");
        putIfValueNotExist(map, "6", "two");
        putIfValueNotExist(map, "7", "five");

        System.out.println("map = " + map);

    }

    static void putIfValueNotExist(Map map, String key, String value) {
        if (!map.containsValue(value)) {
            map.put(key, value);
        }
    }
}