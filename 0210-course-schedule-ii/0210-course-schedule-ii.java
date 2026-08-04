class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;

            for(int neigh: graph.get(node)) {
                indegree[neigh]--;

                if(indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        if(index == numCourses) {
            return order;
        }

        return new int[0];
    }
}