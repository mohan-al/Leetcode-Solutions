class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols-1);
        }

         for(int j=0; j<cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows-1, j);
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;

        if(row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') return;

        board[row][col] = 'T';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}