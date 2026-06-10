class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while(sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if(sb.indexOf(b) != -1) return count;
        sb.append(a);
        if(sb.indexOf(b) != -1) return count+1;

        return -1;
    }
}