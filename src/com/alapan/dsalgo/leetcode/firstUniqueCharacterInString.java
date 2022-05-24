//https://leetcode.com/problems/first-unique-character-in-a-string/
/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 */
package com.alapan.dsalgo.leetcode;

import java.util.HashMap;

public class firstUniqueCharacterInString { //O(n) Time Complexity.Space complexity O(1) because English alphabet contains 26 letters.

    public int bruteforce(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (charCount.containsKey(s.charAt(i))) {
                charCount.put(s.charAt(i), charCount.get(s.charAt(i)) + 1);
            } else {
                charCount.put(s.charAt(i), count);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        firstUniqueCharacterInString obj = new firstUniqueCharacterInString();
        System.out.println(obj.bruteforce("leetcode"));
        System.out.println(obj.bruteforce("loveleetcode"));
        System.out.println(obj.bruteforce("aabb"));
        System.out.println(obj.bruteforce("aadadaad"));
    }
}


//        if(map.size() == 0){ //Check the size of the Hashmap
//            return -1;
//        }
//        return Collections.min(map.values()); //Min of all values in hashmap

