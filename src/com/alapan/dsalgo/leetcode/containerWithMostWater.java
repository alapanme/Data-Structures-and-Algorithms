//https://leetcode.com/problems/container-with-most-water/

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Approach to solve - We have to maximize the Area that can be formed between the vertical lines using the shorter line as length
and the distance between the lines as the width of the rectangle forming the area.
 */
package com.alapan.dsalgo.leetcode;

public class containerWithMostWater {

    public int maxAreaBruteForce(int[] height) { //Time Complexity is O(n^2). Space Complexity is O(1)
        int max_area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max_area = Math.max(max_area, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max_area;
    }

    public int maxAreaOptimized(int[] height) { //Time Complexity is O(n). Space Complexity is O(1)
        /*
        Refer Image - https://assets.leetcode.com/users/images/a20fc8ef-39cb-457a-8ddd-51026ff15899_1613655786.1254294.png

        Image Explanation: If we apply force on Left and right side of jelly like substance, it maintains its shape by
        increasing height. So, in a similar way, to get maximum area we need to find maximum height as we are decreasing width.
        Common Sense:
        Suppose, we have rectangle.
        Area of rectangle(Jelly) = Width * height.
        => Width = Area of rectangle / Height
        => Width ∝ 1/Height Since, area of constant.
        This means, if width decreases, height need to be increased to achieve same area or area greater than previous one.

        >>>>> In simple words, We want to increase the area, so this means height of the bars should be increased to compensate the
        decreasing width to achieve the maximum area. So, we are finding the maximum height from left and right in 2 pointer
        solution while reducing the width. It's simple math.
         */
        int max_area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max_area = Math.max(max_area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        containerWithMostWater obj = new containerWithMostWater();
        System.out.println(obj.maxAreaBruteForce(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(obj.maxAreaOptimized(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
