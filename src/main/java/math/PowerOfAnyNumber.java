package math;

public class PowerOfAnyNumber {
    public static double myPow1(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double pow = 1;
        while(n != 0){
            if((n & 1) != 0){
                pow *= x;
            }
            x *= x;
            n >>>= 1;
        }
        return pow;
    }

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return pow(x, n);
    }

    public static double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1 || n == -1) {
            return x;
        }
        if(n % 2 == 0) {
            double half = pow(x, (n/ 2));
            return half * half;
        } else {
            double half = pow(x, (n/ 2));
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        double x = 34.00515;
        int n = -3;
        System.out.println(myPow(x, n));
    }
}
