class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        // Not considering last house
        int case1 = solve(nums, 0, n-2);
        // Not considering first house
        int case2 = solve(nums, 1, n-1);

        return Math.max(case1, case2);
    }
    private int solve(int[] nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i=start; i<=end; i++) {

        int take = nums[i] + prev2;
        int notTake = 0 + prev1;

        int current = Math.max(take, notTake);
        prev2 = prev1;
        prev1 = current;
        
        }

        return prev1;
    }
}