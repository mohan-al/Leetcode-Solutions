class Solution {
    private boolean canShip(int[] weights, int days, int capacity) {
        int day = 1;
        int load = 0;
        for(int weight: weights) {
        
            if(load + weight > capacity) {
                day++;
                load = weight;
            }
            else {
                load += weight;
            }
        }
        return day <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight: weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while(low < high) {
           int mid = low + (high - low) / 2;

           if(canShip(weights, days, mid)) {
            high = mid;
           }
           else {
            low = mid + 1;
           }
        }
        return low;
    }
}