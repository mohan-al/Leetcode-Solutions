class Solution {
    static class Pair {
        int effort;
        int row;
        int col;

        Pair(int effort, int row, int col) {
            this.effort = effort;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] dist = new int[rows][cols];
        for(int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.effort - b.effort);
        pq.offer(new Pair(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()) {
            Pair current = pq.poll();

            int effort = current.effort;
            int row = current.row;
            int col = current.col;

            if(row == rows -1 && col == cols-1) return effort;

            for(int i=0; i<4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                    int difference = Math.abs(heights[row][col] - heights[newRow][newCol]);

                    int newEffort = Math.max(effort, difference);

                    if(newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.offer(new Pair(newEffort, newRow, newCol));
                    }
                }
            }
        }
        return 0;
    }
}