//https://leetcode.com/problems/3sum-closest/solution/
//Very Well Explained - https://www.youtube.com/watch?v=qBr2hq4daWE

/*
Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
 */

package com.alapan.dsalgo.leetcode;

import java.util.Arrays;

public class threeSumClosest {
    public int twoPointerSolution(int[] nums, int target) {
        /*
        Time Complexity: O(n^2).
        Space Complexity: Space Complexity: from O(log n) to O(n), depending on the implementation of the sorting algorithm.
         */
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int current_sum = nums[i] + nums[lo] + nums[hi];
                if (current_sum > target) { //we need the current sum to be smaller, hence we will move the end pointer hi left, because the array is sorted,
                    // moving left is going towards a less value
                    hi--;
                } else {
                    lo++;
                }
                if (Math.abs(current_sum - target) < Math.abs(result - target)) { //Here we are searching for the lesser difference,
                    // the lesser the difference the closer it is to the target
                    result = current_sum;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        threeSumClosest obj = new threeSumClosest();
        System.out.println(obj.twoPointerSolution(new int[]{-1, 2, 1, -4}, 1));
    }

}
