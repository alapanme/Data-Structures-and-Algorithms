package com.alapan.dsalgo.leetcode;

public class palindromeSolution {
    public boolean isPalindromeBruteForce(int x) { //O(n) time complexity
        String orig = String.valueOf(x);
        StringBuilder rev = new StringBuilder();
        for (int i = orig.length() - 1; i >= 0; i--) {
            rev.append(orig.charAt(i));
        }
        return orig.equals(rev.toString());
    }

    public boolean isPalindromeOptimized(int x) { //O(n) time complexity
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = (rev * 10) + (x % 10);    //0+1=1     //10+2=12   //120+3=123
            x /= 10;   //1232   //123   //12
        }
        if (x == rev || x == rev / 10) {    //12=123/12
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        palindromeSolution obj = new palindromeSolution();
        boolean boolBruteForce = obj.isPalindromeBruteForce(1234321);
        System.out.println("Is the Number Palindrome: " + boolBruteForce);
        boolean boolOptimized = obj.isPalindromeOptimized(12321);
        System.out.println("Is the Number Palindrome: " + boolOptimized);
    }
}
