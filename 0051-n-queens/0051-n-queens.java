class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2*n -1];
        boolean[] anti = new boolean[2*n -1];

        solve(0, n, board, col, diag, anti, ans);
        
        return ans;
    }

    private void solve(int row, int n, char[][] board, boolean[] col, boolean[] diag, boolean[] anti, List<List<String>> ans) {
        if(row == n) {
            ans.add(construct(board));
            return;
        }

        for(int c=0; c<n; c++) {
            int d = row - c + n - 1;
            int ad = row + c;

            if(!col[c] && !diag[d] && !anti[ad]) {
                board[row][c] = 'Q';
                col[c] = true;
                diag[d] = true;
                anti[ad] = true;

                solve(row+1, n, board, col, diag, anti, ans);

                board[row][c] = '.';
                col[c] = false;
                diag[d] = false;
                anti[ad] = false;

            }
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] row: board) {
            list.add(new String(row));
        }
        return list;
    }
}