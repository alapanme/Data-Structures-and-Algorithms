package com.alapan.dsalgo.leetcode;

public class maximumSubArrayKadanesAlgo {

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

    public int optimizedSolution(int[] a) { //Time Complexity is O(n)
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
        maximumSubArrayKadanesAlgo ka = new maximumSubArrayKadanesAlgo();
        System.out.println(ka.bruteForceSolution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(ka.optimizedSolution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
