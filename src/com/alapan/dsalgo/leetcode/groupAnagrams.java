//https://leetcode.com/problems/group-anagrams/
/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */

package com.alapan.dsalgo.leetcode;

import java.util.*;

public class groupAnagrams {

    public List<List<String>> optimized(String[] s) {
        /*
        Maintain a map ans : {String -> List} where each key \text{K}K is a sorted string,
        and each value is the list of strings from the initial input that when sorted, are equal to \text{K}K.

        In Java, we will store the key as a string, eg. code.
        In Python, we will store the key as a hashable tuple, eg. ('c', 'o', 'd', 'e').
         */
        if (s.length == 0) return new ArrayList<>();
        HashMap<String, List> result = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char[] sArray = s[i].toCharArray();
            Arrays.sort(sArray);
            String key = String.valueOf(sArray);
            if (!result.containsKey(key)) result.put(key, new ArrayList<>());
            result.get(key).add(s[i]);
        }
        return new ArrayList(result.values());
    }

    public static void main(String[] args) {
        groupAnagrams obj = new groupAnagrams();
        System.out.println(obj.optimized(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
