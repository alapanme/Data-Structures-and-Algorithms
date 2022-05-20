//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package com.alapan.dsalgo.leetcode;

public class buyAndSellStock {

    public int bruteForceMaxProfit(int[] prices) { //Time Complexity is O(n^2). Space complexity is O(n).
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public int optimizedMaxProfit(int[] prices) { //Time Complexity is O(n). Space complexity is O(1).
        /*
        Approach 2: One Pass

        Say the given array is:
        [7, 1, 5, 3, 6, 4]

        We then plot the numbers of the given array on a graph. The points of interest are the peaks and valleys in the given graph.
        We need to find the largest peak following the smallest valley.
        We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and
        maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
         */
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        buyAndSellStock obj = new buyAndSellStock();
        System.out.println(obj.bruteForceMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.optimizedMaxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
