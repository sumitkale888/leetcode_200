public class lc121_besttimetobuy {
    
}
class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
           if(prices[i]<min){
            min=prices[i];
           }
           else if(prices[i]-min>max){
            max=prices[i]-min;
           }
        }
        return max;
         }}

//          Intuition

// To make the maximum profit, you need:

// Buy at the lowest price.
// Sell at a higher price that comes after the buy day.

// Instead of checking every pair of days (O(n²)), we scan the array once.

// We keep track of:

// min → the lowest stock price seen so far (best day to buy).
// max → the maximum profit found so far.
// Algorithm

// For every price:

// If the current price is smaller than min, update min.
// We found a better day to buy.

// Otherwise, calculate the profit if we sell today:

// profit = prices[i] - min;

// If this profit is greater than max, update max.