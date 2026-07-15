class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] arr = s.trim().split("\\s+");

        int n = arr.length;

        for(int i=n-1; i>=0; i--) {
            ans.append(arr[i]);

            if(i != 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}