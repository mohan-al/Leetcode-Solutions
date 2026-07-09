class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }
    private void solve(int index, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        solve(index + 1, nums, list, ans);

        list.remove(list.size() - 1);

        solve(index + 1, nums, list, ans);
    }
}