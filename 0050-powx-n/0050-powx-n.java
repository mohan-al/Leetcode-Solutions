class Solution {
    public double myPow(double x, int n) {
        long N = n;

        if(N < 0) {
            x = 1/x;
            N = -N;
        }

        double pow = 1.0;

        while(N > 0) {
            if((N & 1) == 1) {
                pow *= x;
            }
            x *= x;
            N >>>=1;
        }
        return pow;

    }
}