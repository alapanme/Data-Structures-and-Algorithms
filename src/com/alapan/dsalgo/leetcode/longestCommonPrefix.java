//https://leetcode.com/problems/longest-common-prefix/
//Good Explanation - https://www.youtube.com/watch?v=bl8ue-dTxgs

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

package com.alapan.dsalgo.leetcode;

public class longestCommonPrefix {
    public String bruteForce(String[] strs) { //Time complexity : O(S), where S is the sum of all characters in all strings. Space complexity : O(1).
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
                /*"
                "This is indexOf method".indexOf("method") = 16
                "method".indexOf("method") = 0
                 */
            while (strs[i].indexOf(prefix) != 0) {
                /*
                String substring(begIndex, endIndex): This method has two variants and
                returns a new string that is a substring of this string. The substring
                begins with the character at the specified index and extends to the end
                of this string or up to endIndex – 1
                 */
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        longestCommonPrefix obj = new longestCommonPrefix();
        System.out.println(obj.bruteForce(new String[]{"flower", "flow", "flight"}));
        System.out.println(obj.bruteForce(new String[]{"dog", "racecar", "car"}));
    }
}
