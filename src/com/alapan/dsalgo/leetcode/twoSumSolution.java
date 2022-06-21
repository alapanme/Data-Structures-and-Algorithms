//https://leetcode.com/problems/two-sum/
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */

package com.alapan.dsalgo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class twoSumSolution {
    public int[] twoSumBruteForce(int[] numbs, int target) {
        //Time Complexity is O(n2)
        for (int i = 0; i < numbs.length - 1; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[i] + numbs[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; //returns empty array
    }

    public int[] twoSumHashMap(int[] numbs, int target) { //Time complexity: O(n). Space complexity: O(n).
        //Time Complexity is O(n).
        //The idea here is we save the array-values as 'key' and array index as 'value' as in the final result we need the index of the two numbers.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            int delta = target - numbs[i];
            if (map.containsKey(delta)) {
                return new int[]{i, map.get(delta)};
            } else {
                map.put(numbs[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        twoSumSolution obj = new twoSumSolution();
        int[] resultBruteForce = obj.twoSumBruteForce(new int[]{2, -4, 188, 12, 6, 3}, 9);
        System.out.print("Result from Brute Force: " + resultBruteForce[0] + "," + resultBruteForce[1]);
        int[] resultHashMap = obj.twoSumHashMap(new int[]{2, -4, 188, 12, 6, 3}, 9);
        System.out.print("\nResult from Hashmap: " + resultHashMap[0] + "," + resultHashMap[1]);
    }
}