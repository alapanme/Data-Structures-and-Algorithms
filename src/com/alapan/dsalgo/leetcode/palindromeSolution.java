//https://leetcode.com/problems/palindrome-number/
/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 */
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

    public boolean isPalindromeOptimized(int x) {

        /*Time Complexity O(log10 n). We divided the input by 10 for every iteration
        Space Complexity O(1)
        */

        /*Intuition:
        The first idea that comes to mind is to convert the number into string, and check if the string is a palindrome,
        but this would require extra non-constant space for creating the string which is not allowed by the problem description.

        Second idea would be reverting the number itself, and then compare the number with original number, if they are the same,
        then the number is a palindrome. However, if the reversed number is larger than int.MAX, we will hit integer overflow problem.

        Following the thoughts based on the second idea, to avoid the overflow issue of the reverted number,
        what if we only revert half of the int number? After all, the reverse of the last half of the palindrome
        should be the same as the first half of the number, if the number is a palindrome.

        For example, if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12",
        and compare it with the first half of the number "12", since 12 is the same as 12, we know that the number is a palindrome.
        Let's see how we could translate this idea into an algorithm.

        Algorithm:
        First of all, we should take care of some edge cases. All negative numbers are not palindrome,
        for example: -123 is not a palindrome since the '-' does not equal to '3'. So we can return false for all negative numbers.

        Now let's think about how to revert the last half of the number. For number 1221, if we do 1221 % 10,
        we get the last digit 1, to get the second to the last digit, we need to remove the last digit from 1221,
        we could do so by dividing it by 10, 1221 / 10 = 122. Then we can get the last digit again by doing a
        modulus by 10, 122 % 10 = 2, and if we multiply the last digit by 10 and add the second last digit,
        1 * 10 + 2 = 12, it gives us the reverted number we want. Continuing this process would give us the reverted number with more digits.

        Now the question is, how do we know that we've reached the half of the number?

        Since we divided the number by 10, and multiplied the reversed number by 10,
        when the original number is less than the reversed number, it means we've processed half of the number digits.
         */
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
