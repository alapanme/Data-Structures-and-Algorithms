//https://leetcode.com/problems/maximum-subarray/

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A sub array is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 */
package com.alapan.dsalgo.leetcode;

public class maximumSubArray {

    public int bruteForceSolution(int[] a) { //Time Complexity is O(n^2)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum = sum + a[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int optimizedSolution(int[] a) { //Time Complexity is O(n). Space Complexity O(1)
        /*
        Approach 2: Dynamic Programming, Kadane's Algorithm

        Intuition:
        Whenever you see a question that asks for the maximum or minimum of something, consider Dynamic Programming as a possibility.
        The difficult part of this problem is figuring out when a negative number is "worth" keeping in a subarray. This question
        in particular is a popular problem that can be solved using an algorithm called Kadane's Algorithm.
        If you're good at problem solving though, it's quite likely you'll be able to come up with the algorithm on your own.
        This algorithm also has a very greedy-like intuition behind it.

        Let's focus on one important part: where the optimal subarray begins. We'll use the following example.

        nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

        We can see that the optimal subarray couldn't possibly involve the first 3 values - the overall sum of those numbers
        would always subtract from the total. Therefore, the subarray either starts at the first 4, or somewhere further to the right.

        What if we had this example though?

        nums = [-2,1000000000,-3,4,-1,2,1,-5,4]

        We need a general way to figure out when a part of the array is worth keeping.

        As expected, any subarray whose sum is positive is worth keeping. Let's start with an empty array,
        and iterate through the input, adding numbers to our array as we go along. Whenever the sum of the array is negative,
        we know the entire array is not worth keeping, so we'll reset it back to an empty array.

        However, we don't actually need to build the subarray, we can just keep an integer variable current_subarray and
        add the values of each element there. When it becomes negative, we reset it to 0 (an empty array).

        Algorithm:
        Initialize 2 integer variables. Set both of them equal to the first value in the array.
            currentSubarray will keep the running count of the current subarray we are focusing on.
            maxSubarray will be our final return value. Continuously update it whenever we find a bigger subarray.

        Iterate through the array, starting with the 2nd element (as we used the first element to initialize our variables).
        For each number, add it to the currentSubarray we are building. If currentSubarray becomes negative, we know it isn't
        worth keeping, so throw it away. Remember to update maxSubarray every time we find a new maximum.

        Return maxSubarray.

        Implementation:
        A clever way to update currentSubarray is using currentSubarray = max(num, currentSubarray + num).
        If currentSubarray is negative, then num > currentSubarray + num.
         */
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum < 0) {
                sum = a[i];
            } else {
                sum = sum + a[i];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        maximumSubArray ka = new maximumSubArray();
        System.out.println(ka.bruteForceSolution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(ka.optimizedSolution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
