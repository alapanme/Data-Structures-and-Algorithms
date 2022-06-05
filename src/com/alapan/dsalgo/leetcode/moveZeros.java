//https://leetcode.com/problems/move-zeroes/
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */

package com.alapan.dsalgo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class moveZeros {

    public ArrayList<Integer> bruteForce(int[] arr) { //O(a+b) Time complexity
        ArrayList<Integer> newArr = new ArrayList<>();
        int zero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } else {
                newArr.add(arr[i]);
            }
        }
        for (int i = 0; i < zero; i++) {
            newArr.add(0);
        }
        return newArr;
    }

    public void moveZeroesOptimized(int[] nums) { //O(n) Time complexity
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        moveZeros mz = new moveZeros();
        System.out.println(mz.bruteForce(new int[]{0, 1, 0, 3, 12}));
        mz.moveZeroesOptimized(new int[]{0, 1, 0, 3, 12});
    }
}
