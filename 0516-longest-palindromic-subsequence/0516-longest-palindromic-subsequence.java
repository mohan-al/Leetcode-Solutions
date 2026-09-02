class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int[] row: dp) {
            Arrays.fill(row, -1);
        } 

        return solve(n-1, n-1, s, rev, dp);
    }
    private int solve(int i, int j, String str1, String str2, int[][] dp) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + solve(i-1, j-1, str1, str2, dp);
        }
        else {
            int moveStr1 = solve(i-1, j, str1, str2, dp);
            int moveStr2 = solve(i, j-1, str1, str2, dp);

            dp[i][j] = Math.max(moveStr1, moveStr2);
        }
        return dp[i][j];
    }
}