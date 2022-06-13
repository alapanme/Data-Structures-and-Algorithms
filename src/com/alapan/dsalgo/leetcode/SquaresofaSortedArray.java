//https://leetcode.com/problems/squares-of-a-sorted-array/
//Good Explanation - https://www.youtube.com/watch?v=4eWKHLSRHPY
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */
package com.alapan.dsalgo.leetcode;

import java.util.Arrays;

public class SquaresofaSortedArray {

    public int[] bruteForce(int[] nums) {//Time Complexity is O(NlogN) - For Loop is O(N) & arrays.sort is O(NLogN). Space Complexity is O(logN)
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    public int[] Optimized(int[] nums) {//Time Complexity is O(n). Space Complexity is O(n)
        /*
        Intuition:
        Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order,
        then some non-negative elements with squares in increasing order.
        For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1],
        and the positive part [4, 5, 6] with squares [16, 25, 36]. Our strategy is to iterate over the negative
        part in reverse, and the positive part in the forward direction.

        Algorithm:
        We can use two pointers to read the positive and negative parts of the array - one pointer j in the positive direction,
        and another i in the negative direction. Now that we are reading two increasing arrays (the squares of the elements),
        we can merge these arrays together using a two-pointer technique.
         */
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresofaSortedArray obj = new SquaresofaSortedArray();
        System.out.println(Arrays.toString(obj.bruteForce(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(obj.Optimized(new int[]{-4, -1, 0, 3, 10})));
    }
}
