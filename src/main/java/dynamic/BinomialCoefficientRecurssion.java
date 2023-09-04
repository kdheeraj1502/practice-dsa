package dynamic;

public class BinomialCoefficientRecurssion {
    public static int nCr(int n, int r){
        {
            if(n < r) return 0;
            if(n == r || r == 0) return 1;
            return nCr(n - 1, r) + nCr(n - 1, r - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(nCr(4, 2));
    }
}
