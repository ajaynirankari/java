package com.gl.Java2023Session04;

public class Sample {
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println("Statement-1");
        System.out.println("Statement-2");

        boolean b = false;
        if (b) {
            System.out.println("Statement-3");
            System.out.println("Statement-4");
        }

        b = true;
        if (b) {
            System.out.println("One True case b = " + b);
        } else {
            System.out.println("One False case");
        }

        int x = 90;
        if (x > 10) {
            System.out.println("Some message");
        }

        int score = 70;
        String grade = "";
        if (score >= 90) {
            System.out.println("A");
            grade = "A";
        } else if (score >= 80) {
            System.out.println("B");
            grade = "B";
        } else if (score >= 70) {
            System.out.println("C");
            grade = "C";
        } else if (score >= 60) {
            System.out.println("D");
            grade = "D";
        } else {
            System.out.println("Fail");
            grade = "F";
        }

        System.out.println("grade = " + grade);


        int a = 0;

        a = a + 1;
        System.out.println(a);

        a = a + 1;
        System.out.println(a);

        a = a + 1;
        System.out.println(a);

        a = a + 1;
        System.out.println(a);

        a = a + 1;
        System.out.println(a);


        System.out.println("---------------------");
        int c = 0;
        while (c < 6) {
            System.out.println("while loop - " + c);
            c = c + 1;
        }
        System.out.println("---------------------");


        int d = 0;
        do
        {
            System.out.println("do while loop -" + d);
            d = d + 1;
        } while (d < 6);

        System.out.println("---------------------");

        // initialize, condition, inc/dec
        for (int f = 4; f < 6; f = f + 1) {
            System.out.println("for loop - " + f);
        }
        System.out.println("----------------------");
        int f1 = 4;
        for (; f1 < 6; f1 = f1 + 1) {
            System.out.println("for loop1 - " + f1);
        }

        System.out.println("----------------------");
        int f2 = 4;
        for (; f2 < 6; ) {
            System.out.println("for loop2 - " + f2);
            f2 = f2 + 1;
        }
        System.out.println("----------------------");

        int f3 = 4;
        for (; ; ) {
            f3 = f3 + 1;
            System.out.println("condition = " + (f3 > 10));
            if (f3 > 10) {
                break;
            }
            System.out.println("for loop3 infinite - " + f3);
        }
        System.out.println("----------------------");

        for (int h = 0; h < 10; h++) {
            if (h == 5) {
                continue;
            }

            if (h == 8) {
                break;
            }
            System.out.println("h=" + h);
        }
        System.out.println("----------------------");

        System.out.println("Completed");
    }
}
