package com.gl.SequencedCollection;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        SequencedCollection<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(3);
        numbers.add(7);

        System.out.println("numbers = " + numbers);
        System.out.println("numbers.getFirst() = " + numbers.getFirst());
        System.out.println("numbers.getLast() = " + numbers.getLast());

        numbers.addFirst(100);
        System.out.println("numbers = " + numbers);
        System.out.println("numbers.getFirst() = " + numbers.getFirst());
        System.out.println("numbers.getLast() = " + numbers.getLast());

        numbers.addLast(900);
        System.out.println("numbers = " + numbers);
        System.out.println("numbers.getFirst() = " + numbers.getFirst());
        System.out.println("numbers.getLast() = " + numbers.getLast());

        System.out.println("numbers = " + numbers);
        numbers.removeFirst();
        System.out.println("numbers = " + numbers);
        numbers.removeLast();
        System.out.println("numbers = " + numbers);

        SequencedCollection<Integer> reversed = numbers.reversed();
        System.out.println("numbers = " + numbers);
        System.out.println("reversed = " + reversed);

        reversed.add(88);
        System.out.println("numbers = " + numbers);
        System.out.println("reversed = " + reversed);

        reversed.addLast(99);
        System.out.println("numbers = " + numbers);
        System.out.println("reversed = " + reversed);

        reversed.removeLast();
        System.out.println("numbers = " + numbers);
        System.out.println("reversed = " + reversed);

        SequencedSet<Integer> sets = new LinkedHashSet<>();
        sets.add(7);
        sets.add(4);

        System.out.println("sets = " + sets);

        sets.addFirst(100);
        System.out.println("sets = " + sets);

        sets.addLast(999);
        System.out.println("sets = " + sets);

        sets.removeFirst();
        System.out.println("sets = " + sets);

        SequencedSet<Integer> reversed1 = sets.reversed();
        System.out.println("reversed1 = " + reversed1);

        SequencedMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "one");
        map.put(5, "five");
        map.put(8, "eight");

        System.out.println("map = " + map);

        map.putFirst(0, "zero");
        System.out.println("map = " + map);

        map.putLast(9, "nine");
        System.out.println("map = " + map);

        System.out.println("map.firstEntry() = " + map.firstEntry());
        System.out.println("map.lastEntry() = " + map.lastEntry());
        System.out.println("map = " + map);

        System.out.println("map.pollFirstEntry() = " + map.pollFirstEntry());
        System.out.println("map = " + map);

        System.out.println("map.pollLastEntry() = " + map.pollLastEntry());
        System.out.println("map = " + map);

        SequencedMap<Integer, String> reversed2 = map.reversed();
        System.out.println("reversed2 = " + reversed2);

        Map<Integer, String> hashtable = new Hashtable<>();
        //SequencedMap<Integer, String> hashtable1 = new Hashtable<>();

    }
}
