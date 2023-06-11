package com.gl.Java2023Session03;

public class Sample {
    public static void main(String[] args) {

        int x = 30;
        float f = 50.9f;
        char ch = 'A';
        String s = "Hello";

        // Operator
        // Assignment   -> =
        int a = 90;

        // Arithmetic   -> + - * / %
        int a1 = 35;
        int b2 = 2;
        int c1 = a1 + b2;
        System.out.println("c1 = " + c1);

        int m = a1 % b2;  // % reminder
        System.out.println("m = " + m);

        // Unary operator   ->   (op) Value
        // (++) Value  - Pre-increment
        //  Value (++)  -> Post increment
        // (--) Value  - Pre-decrement
        //  Value ()  -> Post-decrement
        // (!) Value


        // Identity value + and - would be -> 0
        // ++d <======> d=d+1
        // --d <======> d=d-1

        // Identity value * and / would be -> 1
        // **d  <======> d=d*1;
        // //d  <======> d=d/1

        int d = 90;
        System.out.println("d = " + d);
        int d1 = d++;  // d++ <==> (d=d+1)
        System.out.println("d = " + d);
        System.out.println("d1 = " + d1);


        int p = 90;
        System.out.println("p = " + p);
        int p1 = ++p;  // ++p <==> (p=p+1)
        System.out.println("p = " + p);
        System.out.println("p1 = " + p1);

        boolean b = false;
        boolean b1 = !b;
        System.out.println("b1 = " + b1);


        // Binary operator  ->   Value1 (op) Value2
        int v1 = 110;
        int v2 = 20;
        int v3 = v1 + v2;
        int v4 = v1 - v2;
        int v5 = v1 / v2;
        int v6 = v1 % v2;

        // Ternary operator ->   Value1 (op) Value2 (op) Value3

        int k = 10;
        int k1 = 19;
        int k3;
        System.out.println("(k > k1) = " + (k > k1));
        if (k > k1) {
            k3 = 100;
        } else {
            k3 = 200;
        }
        System.out.println("k3 = " + k3);

        k3 = (k > k1) ? 100 : 200;
        System.out.println("k3 = " + k3);

        // Equality operator
        //  ==  (equal)
        int x1 = 40;
        int x2 = 20;
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);

        if (x1 == x2) {
            System.out.println(" == ");
        } else {
            System.out.println(" != ");
        }
        boolean r = x1 == x2;
        if (r) {
            System.out.println(" == ");
        } else {
            System.out.println(" != ");
        }

        //  !=  (not equal)

        if (x1 != x2) {
            System.out.println(" != ");
        } else {
            System.out.println(" == ");
        }
        boolean r1 = x1 != x2;
        if (r1) {
            System.out.println(" != r1=" + r1);
        } else {
            System.out.println(" == r1" + r1);
        }


        //  <  (less than)
        if (x1 > x2) {
            System.out.println("x1>x2");
        } else {
            System.out.println("NOT x1>x2");
        }

        //  <=  (less than or equal)
        //  >  (greater than)
        //  >= (greater than or equal)


        // Logical operator  // short circuit operator
        // && - AND             (boolean var) && (boolean var)
        // || - OR
        // |  - NOT  (Negate)

        boolean bb1 = (x1 > x2);
        boolean bb2 = (k1 > k3);

        if ((x1 > x2) && (k1 > k3)) {

        } else {

        }

        if (bb1 || bb2) {

        } else {

        }

        int val1 = 1;
        int val2 = 2;

        if (val1 == 1 && val2 == 2) {
            System.out.println("&& val2 = " + val2);
        }

        if (val1 == 3 || val2 == 2) {
            System.out.println("|| val2 = " + val2);
        }

        //  5+5*6/6-10

        int f1 = (5 + 5) * 6 / 6 - 10; // expression
        System.out.println("f = " + f1);   // statement


        String s1 = "Hello";
        String s2 = " Test";

        String s3 = s1 + s2;
        System.out.println("s3 = " + s3);

        // Bitwise operator
        // &
        // |
        // !
        // ^
        int dd1 = 3;
        int dd2 = 5;
        int rr = dd1 & dd2;
        System.out.println("rr = " + rr);

    }
}
