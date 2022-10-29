package com.gl.puzzle;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.String.CASE_INSENSITIVE_ORDER;

public class Sample {
    public static void main(String[] args) throws Exception {


        String[] s = {"one", "two", "three"};
        System.out.println("Arrays.toString(s) = " + Arrays.toString(s));

        List<String> strings = Arrays.asList(s);
        System.out.println("strings = " + strings);

        int[] a = {1, 2, 3};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));

        List<int[]> ints = Arrays.asList(a);
        System.out.println(ints);

//---------------------------------------------------------------------------

        ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> subList = integers.subList(0, 0);
        System.out.println("subList = " + subList);
        subList.addAll(List.of(10, 11, 12));
        System.out.println("integers = " + integers);
//---------------------------------------------------------------------------
        String[] strings_ = {"a", "b", "c", null};
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strings_));

        List<String> strings1 = Stream.of(strings_).toList();
        System.out.println("strings1.size() = " + strings1.size());
        List<String> strings2 = List.of(strings_);
        System.out.println("strings2.size() = " + strings2.size());
//---------------------------------------------------------------------------

        String[] strs = {"a", "b", "c", null};
        System.out.println("Arrays.toString(strings) = " + Arrays.toString(strs));
        List<String> strs1 = Arrays.asList(strs);

        strs1.removeIf(Objects::isNull);
        System.out.println("strings1.size() = " + strs1.size());
//---------------------------------------------------------------------------

        Map<Integer, String> map = new HashMap<>();
        map.put(4, null);
        System.out.println(map);
        System.out.println(map.get(4));
        System.out.println(map.getOrDefault(4, "four"));
        map.putIfAbsent(4, "four");
        System.out.println(map.get(4));
//---------------------------------------------------------------------------

        List<Integer> ins = List.of(-1, 0, 1);
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        ins.forEach(n -> map1.putIfAbsent(n, new ArrayList<>()).add(n));
        System.out.println(map1.get(0));

//---------------------------------------------------------------------------

        List<Integer> ins1 = List.of(-1, 0, 1);
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        ins1.forEach(n -> map2.computeIfAbsent(n, ArrayList::new).add(n));
        System.out.println(map2.get(0));

        Function<Integer, List<Integer>> function_ = ArrayList::new;

        Function<Integer, List<Integer>> function = initialCapacity -> new ArrayList<Integer>(initialCapacity);

//---------------------------------------------------------------------------

        Set<String> hashSet = new HashSet<>(List.of("a", "b", "c"));
        Set<String> treeSet = new TreeSet<>(CASE_INSENSITIVE_ORDER);
        treeSet.addAll(List.of("A", "B", "C"));
        System.out.println("hashSet = " + hashSet);
        System.out.println("treeSet = " + treeSet);

        System.out.println(treeSet.equals(hashSet));
        System.out.println(hashSet.equals(treeSet));
//---------------------------------------------------------------------------


        var map3 = new IdentityHashMap<Integer, String>();
        //var map = new HashMap<Integer,String >();
        map3.put(1, "one");
        map3.put(10, "ten");
        map3.put(100, "hundred");
        map3.put(1000, "thousand");
        System.out.println("map = " + map3);
        System.out.println("map.size() = " + map3.size());
        map3.put(1, "one again");
        map3.put(10, "ten again");
        map3.put(100, "hundred again");
        map3.put(1000, "thousand again");
        System.out.println("map = " + map3);
        System.out.println("map.size() = " + map3.size());
        //JVM cache int 1 to 127
//---------------------------------------------------------------------------

        Map<String, Integer> map4 = LinkedHashMap.newLinkedHashMap(3);
        map4.put("a", 1);
        map4.put("b", 2);
        map4.put("c", 3);
        map4.put("b", 4);
        System.out.println(map4.get("a"));
        System.out.println(map4);
//---------------------------------------------------------------------------

        var int_ = List.of(1, 2, 3);
        var a_ = Arrays.asList(1, 2, 3);
        var c = Collections.unmodifiableCollection(int_);
        var l = Collections.unmodifiableList(int_);

        System.out.println(a_.equals(c));
        System.out.println(a_.equals(l));
        System.out.println(c.equals(l));
    }
}