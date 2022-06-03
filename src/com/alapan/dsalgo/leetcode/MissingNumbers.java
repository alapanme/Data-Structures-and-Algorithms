//https://leetcode.com/problems/missing-number/
/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
package com.alapan.dsalgo.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumbers {

    public int hashSetSolution(int[] nums) { //Time Complexity is O(n). Space Complexity is O(n)
        Arrays.sort(nums);
        HashSet<Integer> seq = new HashSet<>();
        for (int num : nums) {
            seq.add(num);
        }
        for (int number = 0; number < nums.length + 1; number++) { //nums.length+1 is because the length on n is in  the range [0, n]
            if (!seq.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public int gaussTheorem(int[] nums) { //Time Complexity is O(n). Space Complexity is O(1)
        /*
        Gauss Theorem = n(n+1)/2
        We can compute the sum of nums in linear time, and by Gauss' formula, we can compute the sum of the first nn natural numbers in constant time.
        Therefore, the number that is missing is simply the result of Gauss' formula minus the sum of nums, as nums consists of the first
        n natural numbers minus some number.
         */
        int expectedSum = (nums.length * (nums.length + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        MissingNumbers obj = new MissingNumbers();
        System.out.println(obj.hashSetSolution(new int[]{3, 0, 1}));
        System.out.println(obj.hashSetSolution(new int[]{0, 1}));
        System.out.println(obj.gaussTheorem(new int[]{3, 0, 1}));
        System.out.println(obj.gaussTheorem(new int[]{0, 1}));
    }
}
