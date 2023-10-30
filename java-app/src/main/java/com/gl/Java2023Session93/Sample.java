package com.gl.Java2023Session93;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sample {
    public static void main(String[] args) {

        // Thread-safe collection

        // These are the NOT thread-safe
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        System.out.println("---------------------------------------------------------");

        // These are the thread-safe
        List<Integer> list1 = new Vector<>();
        Map<String, Integer> map1 = new Hashtable<>();
        Stack stack;
        Properties properties;
        Dictionary<String, Integer> dictionary;
        System.out.println("---------------------------------------------------------");

        List<Integer> list2 = Collections.synchronizedList(list);
        List<Integer> list3 = Collections.synchronizedList(new ArrayList<>());
        Set<Integer> set1 = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> map2 = Collections.synchronizedMap(new HashMap<>());
        System.out.println("---------------------------------------------------------");

        List<Integer> list4 = new CopyOnWriteArrayList<>();
        Set<Integer> set4 = new CopyOnWriteArraySet<>();
        Map<String, Integer> map4 = new ConcurrentHashMap<>();
        System.out.println("---------------------------------------------------------");

        List<Integer> list5 = List.of(0, 1, 2, 3, 4);
        Set<Integer> set5 = Set.of(2, 3, 4, 5);
        Map<String, Integer> map5 = Map.of("one", 1, "two", 2);
        System.out.println("---------------------------------------------------------");

        // Prefer Lock interface over synchronized keyword
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            list.add(56);
            System.out.println("line 1 ");
            System.out.println("line 1 ");
            System.out.println("line 1 ");
        } finally {
            lock.unlock();
        }
        System.out.println("---------------------------------------------------------");
    }
}
