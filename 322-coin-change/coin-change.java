class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int curr = 1; curr<= amount; curr++) {
            for(int coin: coins) {
                if(coin <= curr) {
                    dp[curr] = Math.min(dp[curr], 1+dp[curr - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}