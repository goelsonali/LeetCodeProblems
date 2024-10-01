package top.interview.questions;

//121. Best Time to Buy and Sell Stock
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
public class BuyAndSellStock {
    //a. Assuming price of stock is always greater than 0
    //b. find the lowest stock price
    public static int getMaxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int profit = 0;
        for(int i = 0; i< prices.length-1; i++) {
            int highestPrice = 0;
            if(prices[i] <= lowestPrice) {
                lowestPrice = prices[i];
            }
            if(prices[i+1] > lowestPrice && prices[i+1] > highestPrice) {
                highestPrice = prices[i+1];
                if(profit < highestPrice - lowestPrice){
                    profit = highestPrice - lowestPrice;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        //test1
        int[] input = new int[] {7,1,5,3,6,4};
        System.out.println("The maximum profit is - " + getMaxProfit(input));

        //test2
        int[] input2 = new int[]{1,2};
        System.out.println("The maximum profit is - " + getMaxProfit(input2));
    }
}
