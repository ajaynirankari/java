package com.gl.Java2023Session49;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(12, "One");
        map.put(13, "Two");
        map.put(14, "Three");
        System.out.println("map = " + map);
        System.out.println("-------------------------------------------------------------");

        map.put(14, "ThreeNew");
        map.put(15, "Two");

        System.out.println("map = " + map);
        System.out.println("-------------------------------------------------------------");

        System.out.println("map.size() = " + map.size());

        System.out.println("map.get(13) = " + map.get(13));
        System.out.println("map.get(14) = " + map.get(14));
        System.out.println("map.get(104) = " + map.get(104));
        System.out.println("-------------------------------------------------------------");

        Set<Integer> allTheKeys = map.keySet();

        Iterator<Integer> iterator = allTheKeys.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = map.get(key);
            System.out.println("key = " + key + ",value = " + value);
        }
        System.out.println("-------------------------------------------------------------");

        for (Integer key : allTheKeys) {
            String value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
        System.out.println("-------------------------------------------------------------");

        allTheKeys
                .forEach(key -> System.out.println("key = " + key + ", value  = " + map.get(key)));

        System.out.println("-------------------------------------------------------------");

        map.keySet()
                .forEach(key -> System.out.println("key = " + key + ", value  = " + map.get(key)));

        System.out.println("-------------------------------------------------------------");

        Collection<String> values = map.values();

        for (String value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("-------------------------------------------------------------");

        values.forEach(value -> System.out.println("value = " + value));

        System.out.println("-------------------------------------------------------------");

        boolean threeNew = map.containsValue("ThreeNew");
        System.out.println("threeNew containsValue = " + threeNew);

        System.out.println("Before remove map = " + map + ", size = " + map.size());
        map.remove(14);
        System.out.println("After remove 14 map = " + map + ", size = " + map.size());


        boolean two = map.containsValue("Two");
        System.out.println("two containsValue = " + two);
        threeNew = map.containsValue("ThreeNew");
        System.out.println("threeNew containsValue = " + threeNew);


        System.out.println("map.containsKey(12) = " + map.containsKey(12));
        System.out.println("map.containsKey(102) = " + map.containsKey(102));
        System.out.println("-------------------------------------------------------------");

        List<Integer> numbers = new ArrayList<>(List.of(4, 3, 7, 2, 8));

        System.out.println("Before sort numbers = " + numbers);


        // Here we have 4 option to call sort method
        // 1. Implementation Class
        // 2. Anonymous Class
        // 3. Lambda Expression
        // 4. Method Reference

        class ImplementationClassOfComparatorInterfaceInAsc implements Comparator<Integer> {

            @Override
            public int compare(Integer num1, Integer num2) {
                return num1 - num2;
            }
        }

        ImplementationClassOfComparatorInterfaceInAsc comparatorObject = new ImplementationClassOfComparatorInterfaceInAsc();

        numbers.sort(comparatorObject);
        System.out.println("After sort numbers = " + numbers);

        class ImplementationClassOfComparatorInterfaceInDesc implements Comparator<Integer> {

            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        }

        numbers.sort(new ImplementationClassOfComparatorInterfaceInDesc());
        System.out.println("After sort numbers = " + numbers);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        numbers.sort(comparator);
        System.out.println("After sort numbers = " + numbers);


        Comparator<Integer> comparator1 = (Integer o1, Integer o2) -> {
            return o1 - o2;
        };

        numbers.sort(comparator1);
        System.out.println("After sort numbers = " + numbers);


        Comparator<Integer> comparator2 = (o1, o2) -> {
            return o1 - o2;
        };

        numbers.sort(comparator2);
        System.out.println("After sort numbers = " + numbers);


        Comparator<Integer> comparator3 = (o1, o2) -> o1 - o2;
        numbers.sort(comparator3);
        System.out.println("After sort numbers = " + numbers);


        numbers.sort((o1, o2) -> o1 - o2);
        System.out.println("After sort numbers = " + numbers);

        numbers.sort((num1, num2) -> num1 - num2);
        System.out.println("Lambda expression sort numbers = " + numbers);

        numbers.sort(Comparator.comparingInt(o -> o));
        System.out.println("Comparator.comparingInt sort numbers = " + numbers);

        numbers.sort(Integer::compareTo);
        System.out.println("Integer::compareTo sort numbers = " + numbers);

        numbers.sort(Sample::sortAsc);
        System.out.println("Sample::sortAsc sort numbers = " + numbers);

        numbers.sort(Sample::sortDesc);
        System.out.println("Sample::sortDesc sort numbers = " + numbers);

        int[] a = {6, 3, 8, 4, 9};
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));


    }

    static int sortAsc(int f, int s) {
        return f - s;
    }

    static int sortDesc(int f, int s) {
        return s - f;
    }
}
