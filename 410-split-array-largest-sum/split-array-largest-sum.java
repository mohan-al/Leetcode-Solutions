class Solution {
    private boolean canSplit(int[] nums, int k, int largest) {
        int count = 1;
        int sum = 0;

        for(int num: nums) {
            if(sum + num <= largest) {
                sum += num;
            }
            else{
                count++;
                sum = num;
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for(int num: nums) {
            low = Math.max(low, num);
            high += num;
        }

        while(low < high) {
            int mid = low + (high- low) / 2;

            if(canSplit(nums, k, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}