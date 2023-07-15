package dynamic;

public class BinomialCoefficientRecurssionMemoisation {
    static int mod = 1000000007;
    public static int nCr(int n, int r, int dp[][]){
        {
            if(n < r) return 0;
            if(n == r || r == 0) return 1;
            if(dp[n][r] != 0) return dp[n][r];
            dp[n][r] = (nCr(n - 1, r, dp) + nCr(n - 1, r - 1, dp))%mod;
            return dp[n][r];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        int dp[][] = new int[n + 1][r + 1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[0][1] = 1;
        dp[1][1] = 1;
        System.out.println(nCr(n, r, dp));
    }
}
