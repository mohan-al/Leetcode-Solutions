class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        int ind1 = (total - 1) / 2;
        int ind2 = total / 2;

        int i=0, j=0, cnt = 0;
        int ele1 = 0, ele2 = 0;

        while(i < m && j < n) {
            int curr;
            if(nums1[i] <= nums2[j]) curr = nums1[i++];
            else curr = nums2[j++];

            if(cnt == ind1) ele1 = curr;
            if(cnt == ind2) ele2 = curr;

            cnt++;
        }
        while(i < m) {
            int curr = nums1[i++];

            if(cnt == ind1) ele1 = curr;
            if(cnt == ind2) ele2 = curr;

            cnt++;
        }

        while(j < n) {
            int curr = nums2[j++];

            if(cnt == ind1) ele1 = curr;
            if(cnt == ind2) ele2 = curr;

            cnt++;
        }

        if(total % 2 == 1) return ele2;

        return (ele1 + ele2) / 2.0;
    }
}