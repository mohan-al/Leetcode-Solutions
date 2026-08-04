class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] edge: prerequisites) {
            int course = edge[0];
            int pre = edge[1];

            graph.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int completed = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            completed++;

            for(int neigh: graph.get(node)) {
                indegree[neigh]--;

                if(indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }
        return completed == numCourses;
    }
}