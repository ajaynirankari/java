package com.gl.MagicNumber;

public class MagicNumberDemo {
    public static void main(String[] args) {
        // Magic Number is a number which digits sum is 1 when its digits are added recursively
        // Example
        // 1234 = 1+2+3+4 = 10
        //                  10 = 1+0 = 1 => It is magic number
        // 1235 = 1+2+3+5 = 11
        //                  11 = 1+1 = 2 => It is NOT a magic number

        System.out.println(isMagicNumber(1234));
        System.out.println(isMagicNumber(1235));
    }

    static boolean isMagicNumber(int number) {
        int digitSum = 0;
        while (number > 0 || digitSum > 9) {
            if (number == 0) {
                number = digitSum;
                digitSum = 0;
            }
            int r = number % 10;
            digitSum = digitSum + r;
            number = number / 10;
        }
        if (digitSum == 1)
            return true;
        else
            return false;
    }
}
