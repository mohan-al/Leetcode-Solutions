class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int start = 0;

        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '(') {
                st.push('(');
            }
            else
            {
                st.pop();
            }

            if(st.isEmpty()) {
                ans.append(s.substring(start + 1, i));
                start = i+1;
            }
        }
        return ans.toString();
    }
}