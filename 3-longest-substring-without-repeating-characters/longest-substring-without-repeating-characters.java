class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = s.length();

        while(right < n) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);

                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}