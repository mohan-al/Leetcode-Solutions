class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][k+1];

        for(int i=n-1; i>=0; i--) {
            int[][] curr = new int[2][k+1];

            for(int buy=0; buy<=1; buy++) {
                for(int cap=1; cap <= k; cap++) {
                    if(buy == 1) {
                       curr[buy][cap] = Math.max(-prices[i] + next[0][cap], next[1][cap]);
                    }
                    else {
                        curr[buy][cap] = Math.max(prices[i] + next[1][cap-1], next[0][cap]);
                    }
                }
            }
            next = curr;
        }
        return next[1][k];
    }
}