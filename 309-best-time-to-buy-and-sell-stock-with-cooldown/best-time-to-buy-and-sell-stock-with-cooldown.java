class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, dp);
    }
    private int solve(int i, int buy, int[] prices, int[][] dp) {
        if(i >= prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            int take = -prices[i] + solve(i+1, 0, prices, dp);
            int notTake = solve(i+1, 1, prices, dp);

            dp[i][buy] = Math.max(take, notTake);
        }
        else {
            int sell = prices[i] + solve(i+2, 1, prices, dp);
            int hold = solve(i+1, 0, prices, dp);

            dp[i][buy] = Math.max(sell, hold);
        }
        return dp[i][buy];
    }
}