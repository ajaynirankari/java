package com.gl.Java2023Session13;

public class Sample {
    public static void main(String[] args) {
        String name = "joHn";
        System.out.println("name = " + name);
        String upperCaseName = toUpperCase(name);
        System.out.println("upperCaseName = " + upperCaseName);

        char v = 'H';
        System.out.println("v = " + v);
        char v1 = (char) (v + 32);
        System.out.println("v1 = " + v1);

        String input1 = "JohNsmiTh";
        String output1 = "Johnsmith";

        String input2 = "JohN smiTh";
        String output2 = "John Smith";

        char cc = '#';
        int ascii = cc;
        System.out.println("cc = " + cc);
        System.out.println("Ascii = " + ascii);

        int n = 97;
        System.out.println("n = " + (char) n);
        char cn = (char) n;
        System.out.println("cn = " + cn);


    }

    static String toUpperCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') { // check input char is in lower case
                char capCh = (char) (ch - 32);
                chars[i] = capCh;
            }
        }
        String output = new String(chars);

//        System.out.println(" ------------------------------");
//        for (char c:chars){
//            System.out.println("c = " + c);
//        }
//        output = "";
//        int length = input.length();
//        for (int i = 0; i < length; i++) {
//            char ch = input.charAt(i);
//            char capCh = (char) (ch - 32);
//            output = output + capCh;
//            System.out.println(i+")output = " + output);
//        }

//        char ch = input.charAt(0);
//        char capCh =  (char) (ch -32);
//        System.out.println("ch = " + capCh);
//
//        char ch1 = input.charAt(1);
//        char capCh1 =  (char) (ch1 -32);
//        System.out.println("ch = " + capCh1);
//
//        char ch2 = input.charAt(2);
//        char capCh2 =  (char) (ch2 -32);
//        System.out.println("ch = " + capCh2);
//
//        char ch3 = input.charAt(3);
//        char capCh3 =  (char) (ch3 -32);
//        System.out.println("ch = " + capCh3);

        return output;
    }
}
