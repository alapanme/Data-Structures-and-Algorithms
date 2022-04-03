package com.alapan.dsalgo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class romanToInteger {

    public int optimizedLeftToRightPass(String s) { //Time Complexity is O(1). Space Complexity is O(1)
        /* MMCMLXXXIX - 2989
        * MMMCMXCIX - 3999
        *
        *
        * Now, recall that each symbol adds its own value, except for when a smaller valued symbol is before a larger valued symbol.
        * In those cases, instead of adding both symbols to the total, we need to subtract the large from the small, adding that instead.
        * Therefore, the simplest algorithm is to use a pointer to scan through the string, at each step deciding whether to add the
        * current symbol and go forward 1 place, or add the difference of the next 2 symbols and go forward 2 places. Here is this algorithm in pseudocode.
        *
        *
        * total = 0
        * i = 0
        * while i < s.length:
              if at least 2 symbols remaining AND value of s[i] < value of s[i + 1]:
                total = total + (value of s[i + 1]) - (value of s[i])
                i = i + 2
              else:
                total = total + (value of s[i])
                i = i + 1
           return total
        */


        Map<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);

        int sum = 0;
        int i = 0;

        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum = sum + (nextValue - currentValue);
                i = i + 2;
            } else {
                sum = sum + currentValue;
                i = i + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        romanToInteger ri = new romanToInteger();
        System.out.println(ri.optimizedLeftToRightPass("MMMCMXCIX"));
    }
}