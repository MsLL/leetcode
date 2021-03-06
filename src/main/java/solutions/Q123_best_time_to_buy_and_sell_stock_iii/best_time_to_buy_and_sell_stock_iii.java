// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
//
//  
// Example 1:
//
//
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//
// Example 2:
//
//
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//
//
// Example 3:
//
//
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
// Example 4:
//
//
// Input: prices = [1]
// Output: 0
//
//
//  
// Constraints:
//
//
// 	1 <= prices.length <= 105
// 	0 <= prices[i] <= 105
//
//


class Solution {
    public int maxProfit(int[] prices) {
        //原始想法：两个dp数组,dp1[i]记录[0,i]只一次交易可以获得的做大利益，从左往右算;dp2[i]记录[i,n-1]只一次交易可以获得的最大利益,从右往左算。
    	//maxProfit=max(dp1[i]+dp2[i+1])
    	//具体实现可以省掉一个dp
    	//1.从右往左遍历一遍,初始化dp2,dp2[i]记录[i,n-1]只一次交易可以获得的最大利益
    	int n=prices.length;
        if(n<2){
            return 0;
        }
    	int[] dp=new int[n];
    	int max=prices[n-1];//[i+1,n-1]区间的最大值
    	int profit=0;//目前可以取得的最大利润
    	for(int i=n-1;i>=0;i--){
    		dp[i]=Math.max(max-prices[i],profit);//若利益<0,置为0
    		profit=Math.max(profit, dp[i]);
    		max=Math.max(max, prices[i]);
    	}
    	//2.从左往右遍历一遍，边遍历边计算
    	int profitMax=0;
    	int min=prices[0];//[0,i]区间的最小值
    	profit=0;//已有的最大利润
    	for(int i=0;i<n-1;i++){
    		profitMax=Math.max(profitMax, prices[i]-min+dp[i+1]);
    		profit=Math.max(profit, prices[i]-min);
    		min=Math.min(min, prices[i]);
    	}
    	profitMax=Math.max(profitMax, prices[n-1]-min);
    	return profitMax;
    }
}
