package com.gl.Java2023Session09;

public class Sample {
    public static void main(String[] args) {
        int x = 10;
        int y = 15;
        int z = 20;

        int add = sumOfThreeNumbers(x, y, z);
        System.out.println("add = " + add);

        add = sumOfThreeNumbers(3, 4, 5);
        System.out.println("add = " + add);

        add = sumOfThreeNumbers(13, 14, 15);
        System.out.println("add = " + add);


        add = sumOfThreeNumbers(103, 104, 150);
        System.out.println("add = " + add);

        //System.out.println("n1 = " + n1 + ", n2 = " + n2 + ", n3 = " + n3);
        int s = x + y + z;
        s = s * 1000;
        s = s / 3;
    }

    public static int sumOfThreeNumbers(int n1, int n2, int n3) {
        System.out.println("n1 = " + n1 + ", n2 = " + n2 + ", n3 = " + n3);
        int s = n1 + n2 + n3;
        s = s * 1000;
        s = s / 3;
        return s;
    }
}

