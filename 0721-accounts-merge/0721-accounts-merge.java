class Solution {
    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if(parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) {
                return;
            }

            if(size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += rootB;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        HashMap<String, Integer> emailtoAccount = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                 String email = accounts.get(i).get(j);
                 if(!emailtoAccount.containsKey(email)) {
                    emailtoAccount.put(email, i);
                 }
                 else {
                    dsu.union(i, emailtoAccount.get(email));
                 }
            }
        }

         HashMap<Integer, List<String>> groups = new HashMap<>();
         for(String email: emailtoAccount.keySet()) {
            int account = emailtoAccount.get(email);
            int root = dsu.find(account);

            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry: groups.entrySet()) {
            int root = entry.getKey();
            List<String> emails = entry.getValue();

            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(root).get(0));
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }
}