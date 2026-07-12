class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        solve(nums, visited, new ArrayList<>(), ans);
        return ans;
    }
    private void solve(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);

                solve(nums, visited, list, ans);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}