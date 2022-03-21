package com.alapan.dsalgo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class twoSumSolution {
    public int[] twoSumBruteForce(int[] numbs, int target) {
        //Time Complexity is O(n2)
        for (int i = 0; i < numbs.length; i++) {
            for (int j = i + 1; j < numbs.length; j++) {
                if (numbs[i] + numbs[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; //returns empty array
    }

    public int[] twoSumHashMap(int[] numbs, int target) {
        //Time Complexity is O(n).
        //The idea here is we save the array-values as key and array index as value as in the final result we need the index of the two numbers.
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbs.length; i++) {
            int delta = target - numbs[i];
            if (map.containsKey(delta)) {
                return new int[]{i, map.get(delta)};
            } else {
                map.put(numbs[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        twoSumSolution obj = new twoSumSolution();
        int[] resultBruteForce = obj.twoSumBruteForce(new int[]{2, 7, 11, 15}, 9);
        System.out.print("Result from Brute Force: " + resultBruteForce[0] + "," + resultBruteForce[1]);
        int[] resultHashMap = obj.twoSumHashMap(new int[]{2, -4, 188, 12, 6, 3}, 9);
        System.out.print("\nResult from Hashmap: " + resultHashMap[0] + "," + resultHashMap[1]);
    }
}