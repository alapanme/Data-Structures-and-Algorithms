//https://leetcode.com/problems/implement-strstr/
//Well Explained Solution - https://www.youtube.com/watch?v=Gjkhm1gYIMw

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */

package com.alapan.dsalgo.leetcode;

public class implementStrStr {

    public int bruteForce(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int bruteForce2(String haystack, String needle) {//Time complexity is O(M*N).
        if (needle == "") return 0;
        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            //The length of the needle is 2, So we minus the length from the original length but since we have two l's we add 1.
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) { //If the j goes to the end, that means the needle string has been found and traversed completely
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        implementStrStr obj = new implementStrStr();
        System.out.println(obj.bruteForce("hello", "ll"));
        System.out.println(obj.bruteForce2("hello", "ll"));
        System.out.println(obj.bruteForce2("aaaaa", "bba"));
    }
}
