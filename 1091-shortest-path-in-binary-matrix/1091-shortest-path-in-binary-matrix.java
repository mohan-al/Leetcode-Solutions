class Solution {
    static class Pair {
        int row; 
        int col; 
        int dist;

        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int  n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 1));
        grid[0][0] = 1;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            if(row == n-1 && col == n-1) return dist;

            for(int k=0; k<8; k++) {
                int newR = row + dr[k];
                int newC = col + dc[k];

                if(newR >=0 && newC >=0 && newR < n && newC < n && grid[newR][newC] == 0) {
                    grid[newR][newC] = 1;
                    queue.offer(new Pair(newR, newC, dist+1));
                }
            }
        }
        return -1;
    }
}