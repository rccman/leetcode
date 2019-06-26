package com.rencc.leetcode.primary.array;

/**
 * @title 买卖股票的最佳时机 II
 *
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Array22 {

    public int maxProfit(int[] prices) {
        if(prices.length <= 0){
            return 0;
        }
        int profit = 0;
        //i:买点指针;j:卖点指针
        int i = 0;
        for(int j = 1; j < prices.length; j++){
            //比较当前买卖是否盈利
            if(prices[i] < prices[j]){
                //买卖一次，计算盈利
                profit += (prices[j] - prices[i]);
                //买卖过后，下次买入点至少是当前卖出点
                i = j;
                continue;
            }
            //当前买卖不盈利，买点指针平移，寻找下次买卖时机
            i++;
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int i = new Array22().maxProfit(nums);
        System.out.println(i);
    }
}
