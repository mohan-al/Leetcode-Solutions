class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(a[i][j] == 1) {
                    dp[j] = 0;
                }
                else if(j > 0) {
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}