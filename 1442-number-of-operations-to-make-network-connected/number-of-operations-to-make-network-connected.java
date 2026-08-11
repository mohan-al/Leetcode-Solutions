class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for(int i=0; i<n; i++) {
           if(!visited[i]) {
            components++;
            dfs(i, graph, visited);
           }
        }
        return components - 1;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for(int neigh: graph.get(node)) {
            if(!visited[neigh]) {
            dfs(neigh, graph, visited);
        }

    }
   }
}