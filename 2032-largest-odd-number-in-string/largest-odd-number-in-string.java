class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int end = n-1; end >=0; end--) {
            char last = num.charAt(end);

            if((last - '0') %2 != 0) {
               return num.substring(0, end+1);          
            }
        }
        return "";
        }
}