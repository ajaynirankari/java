package com.gl.Java2023Session24;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(1, 10);
            System.out.println(i + ") ---------> Line 1 in side loop = " + i + ", rand = " + rand + " " + (rand > 7));
            if (rand > 7) {
                break;
            }
            System.out.println(i + ") ---------> Line 2 in side loop = " + i + ", rand = " + rand + " " + (rand > 7));
        }
        System.out.println("-------------> --------->  Outside of the loo ");


        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(1, 10);
            System.out.println(i + ") ---------> Line 1 in side loop = " + i + ", rand = " + rand + " " + (rand > 7));
            if (rand > 7) {
                continue;
            }
            System.out.println(i + ") ---------> Line 2 side loop = " + i + ", rand = " + rand + " " + (rand > 7));
        }
        System.out.println("-------------> --------->  Outside of the loop");


        for (int i = 1; i < 10; i++) {
            System.out.println(i + " ---> " + (i % 2 == 0));
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(" ---------> Odd Number ---> " + i);
        }
    }
}
