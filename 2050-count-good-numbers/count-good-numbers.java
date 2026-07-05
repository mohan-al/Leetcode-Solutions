class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1) / 2;
        long odd = n / 2;

        long eChoice = power(5, even);
        long oChoice = power(4, odd);

        return (int) ((eChoice * oChoice) % MOD);
    }
    private long power(long base, long exp) {
        if(exp == 0) return 1;

        long result = 1;

        long half = power(base, exp/2);

        if(exp % 2 == 0) {
            result = (half * half)%MOD; 
        }
        else {
            result = (half * half * base) % MOD;
        }
        return result;
    }
}