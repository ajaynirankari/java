package com.gl.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
    public static void main(String[] args) {
        //ArrayList arrayList = new ArrayList();
        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        //arrayList.add(3.5);

        Object o = arrayList.get(0);

        int total = 0;
        for (Object obj : arrayList) {
            total += (Integer) obj;
        }
        System.out.println("total = " + total);

        for (int obj : arrayList) {
            total += obj;
        }
        System.out.println("total = " + total);

        Test test = new Test(34);
        test.calculation(45);
        test.calculation(4.5);
        test.calculation(45.5f);


        //Test<Integer,Float,String> test1= new Test<>(56);
        Test<Integer> test1 = new Test<>(56);
        System.out.println("test1.getData() = " + test1.getData());
        print(34, "one");
        print("test", 7);
        print(5.6, "test");

        List<Number> numberList = List.of(1, 2, 3);
        List<Integer> integerList = List.of(1, 2, 3);
        List<Double> doubleList = List.of(1.1, 2.2, 3.3);
        List<Long> longList = List.of(1l, 2l, 3l);

        sort(integerList);
        //sort(numberList); Not allowed
        //sort(doubleList); Not allowed
        //sort(longList); Not allowed

        sort1(integerList);
        sort1(numberList);
        //sort1(doubleList); Not allowed
        //sort1(longList); Not allowed

        List<A> aList = List.of(new A());
        List<B> bList = List.of(new B());
        List<C> cList = List.of(new C());
        List<D> dList = List.of(new D());

        show(aList);
        show(bList);
        show(cList);
        //show(dList); Not allowed
    }

    static void show(List<? super C> list) {
        System.out.println("list = " + list.get(0).getClass());
    }

    static void show1(List<? extends C> list) {
        System.out.println("list = " + list.get(0).getClass());
    }

    static void sort(List<? extends Integer> list) {
        System.out.println("list = " + list.get(0).getClass());
    }

    static void sort1(List<? super Integer> list) {
        System.out.println("list = " + list.get(0).getClass());
    }

    static <T, R, E> R print(T data, R ret) {
        System.out.println("data.getClass() = " + data.getClass());
        return ret;
    }


}

class A {
}

class B extends A {
}

class C extends B {
}

class D extends C {
}

interface TestIn<T> {
}

interface MyInterface {
}

//class Test<T, K, Value, Y extends A & TestIn, Z extends MyInterface> {
class Test<T> {
    private T data;

    Test(T d) {
        data = d;
    }

    public void calculation(T a) {
        data = a;
        System.out.println("calculation a = " + a.getClass());
    }

    public T getData() {
        return data;
    }

    public void calculation(int a) {
        System.out.println("int calculation a = " + a);
    }

    public void calculation(double a) {
        System.out.println("double calculation a = " + a);
    }

    public void calculation(float a) {
        System.out.println("float calculation a = " + a);
    }
}