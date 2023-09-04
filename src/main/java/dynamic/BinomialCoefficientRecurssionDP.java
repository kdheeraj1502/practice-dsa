package dynamic;

public class BinomialCoefficientRecurssionDP {
    static int mod = 1000000007;
    public static int nCr(int n, int r){
        int dp[][] = new int[n + 1][r + 1];
        dp[0][0] = 1;
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= r; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1])%mod;
            }
        }
        return dp[n][r];
    }

    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        System.out.println(nCr(n, r));
    }
}
