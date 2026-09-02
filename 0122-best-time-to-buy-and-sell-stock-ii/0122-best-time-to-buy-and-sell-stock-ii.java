class Solution {
    public int maxProfit(int[] prices) {
        int[] next= new int[2];

        for(int i=prices.length - 1; i>=0; i--) {
            int[] curr = new int[2];
            curr[1] = Math.max(-prices[i] + next[0], next[1]);
            curr[0] = Math.max(prices[i] + next[1], next[0]);

            next = curr;
        }
        return next[1];
    }
}