class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while(sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        String str = sb.toString();
        if(str.contains(b)) return count;

        sb.append(a);
        str = sb.toString();
        if(str.contains(b)) return count+1;

        return -1;
    }
}