package com.alapan.dsalgo.leetcode;

public class reverseIntegerSolution {

    public int reverseBruteForce(int x) {   //O(n) Time Complexity
        long extractedNumber = 0;
        String finalNumber = "";
        long y = Math.abs(Long.valueOf(x));  //Change negative to positive
        long len = String.valueOf(y).length();  //Convert to string and get the length of the number
        for (int i = 0; i < len; i++) {
            extractedNumber = y % 10;
            y = y / 10;
            finalNumber = finalNumber + String.valueOf(extractedNumber);
        }
        if (Long.valueOf(finalNumber) > (Math.pow(2, 31) - 1)) {
            return 0;
        } else {
            if (x < 0) {
                return -(Integer.parseInt(finalNumber));
            } else {
                return Integer.parseInt(finalNumber);
            }
        }
    }

    public int reverseOptimized(int x) {    //O(n) Time Complexity
        long rev = 0;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x = x / 10;
        }
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) rev;
    }

    public static void main(String[] args) {
        reverseIntegerSolution obj = new reverseIntegerSolution();
        int revBruteForce = obj.reverseBruteForce(214748);
        int revOptimized = obj.reverseOptimized(-2147483648);
        System.out.println(revBruteForce);
        System.out.println(revOptimized);
    }
}
