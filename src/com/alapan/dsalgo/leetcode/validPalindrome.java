//https://leetcode.com/problems/valid-palindrome/
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

package com.alapan.dsalgo.leetcode;

public class validPalindrome {

    public boolean isPalindrome(String s) { //O(n) Time Complexity. O(n) space complexity
        if (s.length() == 1) return true;
        String orig = s.toLowerCase().replaceAll("[^a-zA-Z0-9]+", "");
        StringBuilder rev = new StringBuilder();
        for (int i = orig.length() - 1; i >= 0; i--) {
            rev.append(orig.charAt(i));
        }
        return orig.equals(rev.toString());
    }

    public boolean optimized(String s) {
    /* Optimized Solution with O(1) Space Complexity

    The resulting algorithm is simple:

    Set two pointers, one at each end of the input string
    If the input is palindromic, both the pointers should point to equivalent characters, at all times. [1]
    If this condition is not met at any point of time, we break and return early. [2]
    We can simply ignore non-alphanumeric characters by continuing to traverse further.
    Continue traversing inwards until the pointers meet in the middle.*/
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        validPalindrome obj = new validPalindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome(" "));
        System.out.println(obj.isPalindrome("race a car"));
        System.out.println(obj.optimized("A man, a plan, a canal: Panama"));
        System.out.println(obj.optimized(" "));
        System.out.println(obj.optimized("race a car"));
    }
}
