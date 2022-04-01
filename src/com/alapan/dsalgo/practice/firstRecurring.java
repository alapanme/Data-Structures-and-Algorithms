package com.alapan.dsalgo.practice;

import java.util.HashSet;

public class firstRecurring {

    public int bruteForceSolution(int[] a) { //O(n) Time complexity
        HashSet<Integer> set = new HashSet<>();
        if (a.length > 1) {
            for (int i = 0; i < a.length; i++) {
                if (set.contains(a[i])) {
                    return a[i];
                } else {
                    set.add(a[i]);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        firstRecurring obj = new firstRecurring();
        System.out.println(obj.bruteForceSolution(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(obj.bruteForceSolution(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(obj.bruteForceSolution(new int[]{1, 2, 3, 4}));
        System.out.println(obj.bruteForceSolution(new int[]{1}));
    }
}
