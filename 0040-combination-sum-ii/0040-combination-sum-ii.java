class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
    private void solve(int index, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index == candidates.length) {
            return;
        }

        list.add(candidates[index]);
        solve(index + 1, candidates, target - candidates[index], list, ans);
        list.remove(list.size() - 1);

        while(index+1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        solve(index + 1, candidates, target, list, ans);
    }
}