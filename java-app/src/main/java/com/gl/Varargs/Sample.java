package com.gl.Varargs;

public class Sample {
    public static void main(String[] args) {
        String msg1 = "Message 1";
        String msg2 = "Message 2";
        String msg3 = "Message 3";
        String msg4 = "Message 4";

        printMessage(msg1, msg2, msg3, msg4);
        System.out.println("========================== ");
        String[] strings = new String[5];
        strings[0] = msg1;
        strings[1] = msg2;
        strings[2] = msg3;
        strings[3] = msg4;
        printMessagesUsingArray(strings);
        String msg5 = "Message 5";
        strings[4] = msg5;
        printMessagesUsingArray(strings);

        System.out.println("========================== ");

        printMessagesUsingVarargs(msg1, msg2, msg3, msg4);
        printMessagesUsingVarargs(msg1, msg2, msg3, msg4, msg5);
        printMessagesUsingVarargs(msg1);
        printMessagesUsingVarargs(msg1, msg2);
        printMessagesUsingVarargs(msg1, msg2, "new message");


        System.out.println(sum("sum", 1, 2));
        System.out.println(sum("sum", 1, 2, 3));
        System.out.println(sum("sum", 1, 2, 3, 4));
        System.out.println(sum("sum", 1, 2, 3, 4, 5));
    }

    static int sum(String msg, int... n) {
        int s = 0;
        for (int t : n) {
            s = s + t;
        }
        return s;
    }

    static void printMessagesUsingVarargs(String... mgs) {
        for (String m : mgs)
            System.out.println(m);
    }

    static void printMessagesUsingArray(String[] mgs) {
        for (String m : mgs)
            System.out.println(m);
    }

    static void printMessage(String mgs1) {
        System.out.println(mgs1);
    }

    static void printMessage(String mgs1, String mgs2) {
        System.out.println(mgs1);
        System.out.println(mgs2);
    }

    static void printMessage(String mgs1, String mgs2, String mgs3) {
        System.out.println(mgs1);
        System.out.println(mgs2);
        System.out.println(mgs3);
    }

    static void printMessage(String mgs1, String mgs2, String mgs3, String mgs4) {
        System.out.println(mgs1);
        System.out.println(mgs2);
        System.out.println(mgs3);
        System.out.println(mgs4);
    }
}
