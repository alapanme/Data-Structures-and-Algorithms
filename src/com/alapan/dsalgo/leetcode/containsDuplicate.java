package com.alapan.dsalgo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsDuplicate {

    public boolean bruteForce(int[] nums) { //O(n^2) Time complexity
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean optimized(int[] nums) { //O(n) Time complexity
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

    public boolean optimized2(int[] nums) { //O(n) Time complexity
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

    public static void main(String[] args) {
        containsDuplicate cd = new containsDuplicate();
        System.out.println(cd.bruteForce(new int[]{1, 2, 3, 4}));
        System.out.println(cd.optimized(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(cd.optimized2(new int[]{1, 2, 4, 5, 4, 1}));
    }
}
