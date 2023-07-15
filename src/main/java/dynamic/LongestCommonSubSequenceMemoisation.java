package dynamic;

public class LongestCommonSubSequenceMemoisation {
    public static int LCS(String x, String y, int m, int n, int dp[][]){
        if(m == 0 || n == 0) return 0;
        if(dp[m][n] != 0) return dp[m][n];
        if(x.charAt(m - 1) == y.charAt(n - 1)){
            return dp[m][n] = 1 + LCS(x, y, m - 1, n - 1, dp);
        } else{
            return dp[m][n] = Math.max(LCS(x, y, m, n - 1, dp), LCS(x, y, m - 1, n, dp));
        }
    }

    public static void main(String[] args) {
        String x  = "AGGTAB";
        String y  = "GXTXAYB";
        int dp[][] = new int[x.length() + 1][y.length() + 1];
        System.out.println(LCS(x, y, x.length(), y.length(), dp));
    }
}
