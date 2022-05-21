//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
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
