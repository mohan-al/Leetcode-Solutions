class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] prev = new int[n+1];

        for(int j=0; j<=n; j++) {
            prev[j] = j;
        }

        for(int i=1; i<=m; i++) {
            int[] curr = new int[n+1];
            curr[0] = i;
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else {
                    int replace = prev[j-1];
                    int insert = curr[j-1];
                    int delete = prev[j];

                    curr[j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}