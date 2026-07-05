class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if(N < 0) {
            x = 1/x;
            N = -N;
        }

        double pow = 1.0;

        while(N > 0) {
            if((N % 2) == 1) {
                pow *= x;
            }
            x *= x;
            N = N/2;
        }
        return pow;

    }
}