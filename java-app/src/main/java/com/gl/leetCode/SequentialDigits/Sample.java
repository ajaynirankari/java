package com.gl.leetCode.SequentialDigits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(1000, 13000));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int num = i;
            for (int j = i + 1; j < 10; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
