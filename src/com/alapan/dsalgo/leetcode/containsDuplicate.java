//https://leetcode.com/problems/contains-duplicate/
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
package com.alapan.dsalgo.leetcode;

import java.util.*;

public class containsDuplicate {

    public boolean bruteForce(int[] nums) { //O(n^2) Time complexity. O(1) Space Complexity
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean optimized(int[] nums) { //O(n) Time complexity. O(n) Space Complexity
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsValue(nums[i])) {
                    return true;
                } else {
                    map.put(i, nums[i]);
                }
            }
        }
        return false;
    }

    public boolean optimized2(int[] nums) { //O(n) Time complexity. O(n) Space Complexity
        Set<Integer> set = new HashSet<>();
        if (nums.length >= 2) {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                } else {
                    set.add(nums[i]);
                }
            }
        }
        return false;
    }

    public boolean optimized3(int[] nums) { //Time complexity is O(nlogn). O(1) Space Complexity
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicate cd = new containsDuplicate();
        System.out.println(cd.bruteForce(new int[]{1, 2, 3, 4}));
        System.out.println(cd.optimized(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(cd.optimized2(new int[]{1, 2, 4, 5, 4, 1}));
        System.out.println(cd.optimized3(new int[]{1, 2, 4, 5, 4, 1}));
    }
}
