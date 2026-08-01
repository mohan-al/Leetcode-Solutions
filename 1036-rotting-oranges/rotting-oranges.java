class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 2) queue.offer(new int[] {i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        if(fresh == 0) return 0;
        int minutes = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisminute = false;


            for(int i=0; i<size; i++) {
                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for(int k=0; k<4; k++) {
                    int newR = row + dr[k];
                    int newC = col + dc[k];

                    if(newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        fresh--;
                        queue.offer(new int[]{newR, newC});
                        rottenThisminute = true;
                    }
                }
            }

            if(rottenThisminute) {
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}