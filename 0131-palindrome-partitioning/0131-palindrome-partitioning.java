class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);

        return ans;
    }
    private void solve(int index, String s, List<String> list, List<List<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                list.add(s.substring(index, i+1));
                solve(i+1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }
}