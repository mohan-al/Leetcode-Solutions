class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(n-1, amount, coins, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int solve(int i, int amount, int[] coins, int[][] dp) {
        if(i == 0) {
            if(amount % coins[0] == 0) {
                return  amount / coins[0];
            }
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1) {
            return dp[i][amount];
        }

        int notTake = solve(i-1, amount, coins, dp);
        int take = Integer.MAX_VALUE;

        if(coins[i] <= amount) {
            int result = solve(i, amount - coins[i], coins, dp);
            if(result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        dp[i][amount] = Math.min(notTake, take);
        return dp[i][amount]; 
    }
}