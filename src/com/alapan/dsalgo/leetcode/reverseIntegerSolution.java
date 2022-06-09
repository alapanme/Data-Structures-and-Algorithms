//https://leetcode.com/problems/reverse-integer/
/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
 */

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

    public int reverseOptimized2(int x) { //Time Complexity: O(log(x)).There are roughly log10(x) digits in x. Space Complexity: O(1).
        /*
        Intuition:
        We can build up the reverse integer one digit at a time.
        While doing so, we can check beforehand whether, or not appending another digit would cause overflow.

        Algorithm:
        Reversing an integer can be done similarly to reversing a string.

        We want to repeatedly "pop" the last digit off of x and "push" it to the back of the rev.
        In the end, rev will be the reverse of the x.

        To "pop" and "push" digits without the help of some auxiliary stack/array, we can use math.

        //pop operation:
        pop = x % 10;
        x /= 10;

        //push operation:
        temp = rev * 10 + pop;
        rev = temp;

        However, this approach is dangerous, because the statement temp=rev*10+pop can cause overflow.

        Luckily, it is easy to check beforehand whether or this statement would cause an overflow.

        To explain, lets assume that rev is positive.

        1. If temp = rev * 10 + pop causes overflow, then it must be that rev ≥ INT_MAX/10
        2. If rev > INT_MAX/10, then temp = rev * 10 + pop is guaranteed to overflow.
        3. If rev == INT_MAX/10, then temp = rev * 10 + pop will overflow if and only if pop > 7.

        Similar logic can be applied when rev is negative.
         */
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        reverseIntegerSolution obj = new reverseIntegerSolution();
        int revBruteForce = obj.reverseBruteForce(214748);
        int revOptimized = obj.reverseOptimized(-2147483648);
        System.out.println(revBruteForce);
        System.out.println(revOptimized);
        System.out.println(obj.reverseOptimized2(-2147483648));
        System.out.println(obj.reverseOptimized2(123));
    }
}
