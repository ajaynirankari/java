package com.gl.JavaTrainingSession08;

public class Sample {
    public static void main(String[] args) {
        boolean flag;
        flag = true;
        System.out.println("flag = " + flag);
        flag = false;
        System.out.println("flag = " + flag);
        //flag =12;   NOT allowed, true or false can any allow for boolean variable only

        boolean evenNo = isEvenNo(57);
        System.out.println("###### evenNo = " + evenNo);
        if (evenNo) {
            System.out.println("TRUE evenNo = " + evenNo);
        } else {
            System.out.println("FALSE evenNo = " + evenNo);
        }

        if (evenNo == true) {
            System.out.println("evenNo = " + evenNo);
        } else {
            System.out.println("evenNo = " + evenNo);
        }

        int[] a = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};

        for (int i = 0; i < a.length; i++) {
            boolean found = isEvenNo(a[i]);
            //if (found == true) {
            if (found) {
                System.out.println("r = " + a[i]);
            } else {
                System.out.println("r = " + a[i]);
            }

            if (found == false) {
                System.out.println("r = " + a[i]);
            }

            if (found == true) {

            } else {
                System.out.println("r = " + a[i]);
            }


            if (found == true) {

            }
            if (found == false) {
                System.out.println("r = " + a[i]);
            }

            if (found == true) {
                //if (found){
                System.out.println("r = " + a[i]);
            }

            if (found == false) {
                //if (!found){
                System.out.println("r = " + a[i]);
            }

            boolean evenNo3 = isEvenNo5(7);
            System.out.println("evenNo3 = " + evenNo3);


        }
    }

    static boolean isEvenNo(int n) {
        boolean result;
        if (n % 2 == 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    static boolean isEvenNo1(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isEvenNo2(int n) {
        boolean b = n % 2 == 0;
        if (b) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isEvenNo3(int n) {
        boolean b = n % 2 == 0;
        return b;
    }

    static boolean isEvenNo4(int n) {
        return n % 2 == 0;
    }

    static boolean isEvenNo5(int n) {
        int m = n % 2;
        boolean isSuccess = m == 0;
        boolean result;
        if (isSuccess == true) {
            result = true;
        } else if (isSuccess == false) {
            result = false;
        } else {
            result = false;
        }
        return result;
    }
}
