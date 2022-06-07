/*
https://leetcode.com/problems/product-of-array-except-self/
Good Explanation - https://www.youtube.com/watch?v=tSRFtR3pv74

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
package com.alapan.dsalgo.leetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] Optimized1(int[] nums) { //Time Complexity is O(n). Space Complexity is O(n)
        /*
        Algorithm:

        Initialize two empty arrays, L and R where for a given index i, L[i] would contain the product of all
        the numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.

        We would need two different loops to fill in values for the two arrays.
        For the array L, L[0] would be 1 since there are no elements to the left of the first element.
        For the rest of the elements, we simply use L[i]=L[i−1]∗nums[i−1].
        Remember that L[i] represents product of all the elements to the left of element at index i.

        For the other array, we do the same thing but in reverse i.e. we start with the initial value of 1
        in R[length - 1]R[length−1] where length is the number of elements in the array, and keep updating R[i] in reverse.
        Essentially, R[i]=R[i+1]∗nums[i+1]. Remember that R[i]
        represents product of all the elements to the right of element at index i.

        Once we have the two arrays set up properly, we simply iterate over the input array one element at a time,
        and for each element at index i, we find the product except self as L[i]∗R[i].
         */
        int len = nums.length;
        int[] left_product = new int[len];
        int[] right_product = new int[len];
        int[] answer = new int[len];
        left_product[0] = 1;
        right_product[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left_product[i] = nums[i - 1] * left_product[i - 1];
        }
        System.out.println("Left Array: " + Arrays.toString(left_product));
        for (int i = len - 2; i >= 0; i--) {
            right_product[i] = nums[i + 1] * right_product[i + 1];
        }
        System.out.println("Right Array: " + Arrays.toString(right_product));
        for (int i = 0; i < len; i++) {
            answer[i] = left_product[i] * right_product[i];
        }
        return answer;
    }

    public int[] Optimized2(int[] nums) { //Time Complexity is O(n). Space Complexity is O(1)
        /*
        Although the above solution is good enough to solve the problem since we are not using division anymore,
        there's a follow-up component as well which asks us to solve this using constant space.
        Understandably so, the output array does not count towards the space complexity.
        This approach is essentially an extension of the approach above.
        Basically, we will be using the output array as one of L or R, and we will be constructing the other one on the fly.
        Let's look at the algorithm based on this idea.

        Algorithm:

        Initialize the empty answer array where for a given index i, answer[i] would contain the product of all the numbers to the left of i.

        We construct the answer array the same way we constructed the L array in the previous approach.
        These two algorithms are exactly the same except that we are trying to save up on space.

        The only change in this approach is that we don't explicitly build the R array from before.
        Instead, we simply use a variable to keep track of the running product of elements to the right, and we
        keep updating the answer array by doing answer[i]=answer[i]∗R.
        For a given index i, answer[i] contains the product of all the elements to the left and R would
        contain product of all the elements to the right. We then update R as R = R * nums[i]
         */
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }
        return answer;
    }


    public static void main(String[] args) {
        ProductofArrayExceptSelf obj = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(obj.Optimized1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(obj.Optimized2(new int[]{1, 2, 3, 4})));
    }
}
