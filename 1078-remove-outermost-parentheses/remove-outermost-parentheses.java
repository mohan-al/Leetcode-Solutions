class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();
        int depth = 0;

        for(char ch: arr)  {
            if(ch == '(') {
                if(depth > 0) {
                    ans.append(ch);
                }
                depth++;
            }
            else {
                depth--;
                if(depth > 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}