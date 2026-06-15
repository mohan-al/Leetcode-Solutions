class Solution {
    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int flower = 0;
        int boque = 0;

        for(int bloom: bloomDay) {
            if(bloom <= day) {
                flower++;
                if(flower == k) {
                    boque++;
                    flower = 0;
                }
            }
            else {
                flower = 0;
            }
        }
        return boque >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k > bloomDay.length ) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int bloom: bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(canMake(bloomDay, m, k, mid)){
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}