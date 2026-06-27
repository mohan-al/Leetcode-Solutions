class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        
        int k = 1;
        temp[0] = nums[0];

        for(int i=1; i<n; i++) {
            if(nums[i] != temp[k-1]) {
                temp[k++] = nums[i];
            }
        }

        for(int i=0; i<k; i++) {
            nums[i] = temp[i];
        }

        return k;
    }
}