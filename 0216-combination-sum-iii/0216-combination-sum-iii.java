class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), ans);

        return ans;
    }
    private void solve(int num, int k , int target, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0 && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if(num > 9 || list.size() > k || target < 0) {
            return;
        }

        list.add(num);
        solve(num+1, k, target - num, list, ans);
        list.remove(list.size() - 1);

        solve(num+1, k, target, list, ans);
    }
}