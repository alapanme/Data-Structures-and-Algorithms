package com.alapan.dsalgo.leetcode;

public class palindromeSolution {
    public boolean isPalindromeBruteForce(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return false;
        } else {
            String orig = String.valueOf(x);
            String rev = "";
            for (int i = orig.length() - 1; i >= 0; i--) {
                rev = rev + orig.charAt(i);
            }
            if (orig.equals(rev)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isPalindromeOptimized(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        if (x == rev || x == rev / 10) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        palindromeSolution obj = new palindromeSolution();
        boolean boolBruteForce = obj.isPalindromeBruteForce(0);
        System.out.println("Is the Number Palindrome: " + boolBruteForce);
        boolean boolOptimized = obj.isPalindromeOptimized(12321);
        System.out.println("Is the Number Palindrome: " + boolOptimized);
    }
}
