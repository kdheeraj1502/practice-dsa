package sample;

public class BinomialCofficientDP {
    static int mod = 1000000007;
    static int nCr(int n, int r)
    {
        int dp[] = new int[r + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = Math.min(i, r); j > 0; j--){
                dp[j] = (dp[j]%mod + dp[j - 1]%mod)%mod;
            }
        }
        return dp[r];
    }
}
