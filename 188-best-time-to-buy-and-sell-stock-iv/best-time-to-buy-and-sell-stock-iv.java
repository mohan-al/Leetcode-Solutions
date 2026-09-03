class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] a: dp) {
            for(int[] b: a) {
                Arrays.fill(b, -1);
            }
        }
        return solve(0, 1, k, prices, dp);
    }
    private int solve(int i, int buy, int k, int[] prices, int[][][] dp) {
           if(i == prices.length || k == 0) return 0;

           if(dp[i][buy][k] != -1) return dp[i][buy][k];

           if(buy == 1) {
            int take = -prices[i] + solve(i+1, 0, k, prices, dp);
            int notTake = solve(i+1, 1, k, prices, dp);

            dp[i][buy][k] = Math.max(take, notTake);
           }
           else {
            int sell = prices[i] + solve(i+1, 1, k-1, prices, dp);
            int hold = solve(i+1, 0, k, prices, dp);

            dp[i][buy][k] = Math.max(sell, hold);
        }
        return dp[i][buy][k];
    }
}