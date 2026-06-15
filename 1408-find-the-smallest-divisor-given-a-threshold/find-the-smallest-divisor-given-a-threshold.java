class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for(int num: nums){
            high = Math.max(high, num);
        }
        
        
        while(low < high) {
            int sum = 0;
            int mid = low + (high - low) / 2;
            for(int num: nums) {
               sum += (num + mid - 1) / mid;
            }

            if(sum <= threshold) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}