class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                Set<Integer> set = new HashSet<>();

                for(int k=j+1; k<n; k++) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    long fourth = (long) target - (sum);

                    if (fourth >= Integer.MIN_VALUE && fourth <= Integer.MAX_VALUE && set.contains((int) fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);
                        result.add(temp);
                    }

                    set.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}