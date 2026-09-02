class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(m-1, n-1, word1, word2, dp);
    }
    private int solve(int i, int j, String word1, String word2, int[][] dp) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = solve(i-1, j-1, word1, word2, dp);
        }

        else {
             int insert = solve(i, j-1, word1, word2, dp);
             int delete = solve(i-1, j, word1, word2, dp);
             int replace = solve(i-1, j-1, word1, word2, dp);

             dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
       }
       return dp[i][j];
    }
}