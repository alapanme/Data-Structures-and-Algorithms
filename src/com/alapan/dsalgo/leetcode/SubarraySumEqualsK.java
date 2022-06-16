//https://leetcode.com/problems/subarray-sum-equals-k/
/*
Given an array of integers nums and an integer k, return the total number of sub-arrays whose sum equals to k.
A sub-array is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 */
package com.alapan.dsalgo.leetcode;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int bruteForce(int[] nums, int k) {//Time complexity : O(n). Space Complexity: O(n)
    /*
    Say you are given an array e.g. [a0, a1, a2, a3, a4, a5, a6... an] .

    [a0, a1, a2, a3, a4, a5, a6, ... an]
	          ^	         ^
            sumI	    sumJ

    sumI = sum of numbers till a2 (a0 + a1 + a2)
    sumJ = sum of numbers till a5 (a0 + a1 + a2 + a3 + a4 + a5)

    Now lets say the difference between sumJ and sumI is equal to k.
    What that means is, the sum of numbers between a2 and a5 is equal to k ( a3 + a4 + a5 = k ), which means we found a
    sub array whose sum is equal to k.

    We can write a3 + a4 + a5 = k as sumJ - sumI = k and,
    sumJ - sumI = k can be written as sumJ - k = sumI

    The expression sumJ - k = sumI, means have we already seen a sum which is equal to sum at current index j minus k. If yes,
    it means we found a sub array whose sum is equal to k.

    And we keep track of how many times we see a particular sum using a HashMap.
     */

        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.bruteForce(new int[]{1, 1, 1}, 2));
    }
}
