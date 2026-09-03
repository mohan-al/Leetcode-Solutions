class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        for(int i=0; i<n; i++) {
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n+1, arr, dp);
    }
    private int solve(int left, int right, int[] arr, int[][] dp) {

        if(left + 1 == right) return 0;
        if(dp[left][right] != -1 ) return dp[left][right];

        int max = 0;

        for(int k=left+1; k<right; k++) {
            int coins = solve(left, k, arr, dp) + solve(k, right, arr, dp) + arr[left] * arr[k] * arr[right];
            max = Math.max(max, coins);
        }

        dp[left][right] = max;
        return dp[left][right];
    }
}