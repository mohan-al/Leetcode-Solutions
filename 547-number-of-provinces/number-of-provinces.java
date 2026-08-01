class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }
        return provinces;
    }
    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        visited[city] = true;

        for(int neigh = 0; neigh < isConnected.length; neigh++) {
            if(isConnected[city][neigh] == 1 && !visited[neigh]) {
                dfs(neigh, isConnected, visited);
            }
        }
    }
}