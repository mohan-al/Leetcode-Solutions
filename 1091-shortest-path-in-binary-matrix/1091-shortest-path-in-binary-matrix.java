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
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

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

            if(row == n-1 && col == n-1) {
                return dist;
            }

            for(int k=0; k<8; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if(newRow >= 0 && newCol >= 0 && newRow < n &&  newCol < n && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1;
                    queue.offer(new Pair(newRow, newCol, dist+1));
                }
            }
        }
        return -1;
    }
}