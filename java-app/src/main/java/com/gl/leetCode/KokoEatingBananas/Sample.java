package com.gl.leetCode.KokoEatingBananas;

public class Sample {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        System.out.println("minEatingSpeed(piles,8) = " + minEatingSpeed(piles, 8));
        int[] p = {30, 11, 23, 4, 20};
        System.out.println("minEatingSpeed(piles,5) = " + minEatingSpeed(p, 5));
    }

    static int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (calculateEatingSpeed(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean calculateEatingSpeed(int[] piles, int h, int k) {
        int hours = 0;
        for (int p : piles) {
            hours = hours + p / k;
            if (p % k != 0) {
                hours++;
            }
        }
        return hours <= h;
    }
}
