//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Really Nicely explained - https://www.youtube.com/watch?v=3IETreEybaA

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


package com.alapan.dsalgo.leetcode;
import java.util.HashSet;

public class lengthOfLongestSubstring {

    public int optimized(String s) { //Solved via sliding window method. O(n) Time Complexity
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                max = Math.max(set.size(), max);
            }
            else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring obj = new lengthOfLongestSubstring();
        System.out.println(obj.optimized("abcabcbb"));
        System.out.println(obj.optimized("pwwkew"));
        System.out.println(obj.optimized(" "));
        System.out.println(obj.optimized("au"));
        System.out.println(obj.optimized(""));
        System.out.println(obj.optimized("aa"));
        System.out.println(obj.optimized("aab"));
    }
}
