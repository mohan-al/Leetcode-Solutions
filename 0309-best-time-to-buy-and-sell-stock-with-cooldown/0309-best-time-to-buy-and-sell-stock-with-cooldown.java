class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] next1 = new int[2];
        int[] next2 = new int[2];

        for(int i=n-1; i>=0; i--) {
            int[] curr = new int[2];

            curr[1] = Math.max(-prices[i] + next1[0], next1[1]);
            curr[0] = Math.max(prices[i] + next2[1], next1[0]);

            next2 = next1;
            next1 = curr;
        }
        return next1[1];
    }
}