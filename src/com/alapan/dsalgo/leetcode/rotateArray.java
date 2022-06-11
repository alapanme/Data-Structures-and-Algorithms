//https://leetcode.com/problems/rotate-array/description/
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
package com.alapan.dsalgo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class rotateArray {  //O(a+b) Time complexity
    public void bruteForceSolution(int[] nums, int k) {
        ArrayList<Integer> newArray = new ArrayList<>();
        int len = nums.length;
        for (int i = len - k; i < len; i++) {
            newArray.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            newArray.add(nums[i]);
        }
        System.out.println(newArray);
    }

    public void optimizedSolution(int[] nums, int k) { //O(n) Time Complexity. Space Complexity O(1)
        //1,2,3,4,5,6,7 - Reverse the whole array 7,6,5,4,3,2,1
        //7,6,5,4,3,2,1 - Reverse the first k numbers 5,6,7,4,3,2,1
        //5,6,7,4,3,2,1 - Reverse the rest of the numbers 5,6,7,1,2,3,4
        k = k % nums.length; //This is for if array length is less than k
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        rotateArray ra = new rotateArray();
        ra.bruteForceSolution(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        ra.optimizedSolution(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
