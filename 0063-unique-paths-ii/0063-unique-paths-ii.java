class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, a, dp, m, n);
    }
    private int solve(int i, int j, int[][] a, int[][] dp, int m, int n) {
        if(i >= m || j >= n) return 0;
        if(a[i][j] == 1) return 0;

        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i+1, j, a, dp, m, n);
        int right = solve(i, j+1, a, dp, m, n);

        dp[i][j] = down + right;
        return dp[i][j];
    }
}