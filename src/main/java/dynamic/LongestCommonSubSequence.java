package dynamic;

public class LongestCommonSubSequence {

    public static int LCS(String x, String y, int m, int n){
        if(m == 0 || n == 0) return 0;
        if(x.charAt(m - 1) == y.charAt(n - 1)){
            return 1 + LCS(x, y, m - 1, n - 1);
        } else{
            return Math.max(LCS(x, y, m, n - 1), LCS(x, y, m - 1, n));
        }
    }

    public static void main(String[] args) {
     //   String x  = "AGGTAB";
    //    String y  = "GXTXAYB";
     //   System.out.println(LCS(x, y, x.length(), y.length()));

        String x = "geeks";
        String y = "geeksfor";
        String z = "geeksforgeeks";
        int dp[][][] = new int[x.length() + 1][y.length() + 1][z.length() + 1];
        System.out.println(LCSof3(x, y, z, x.length(), y.length(), z.length(), dp));
    }

   static int LCSof3(String A, String B, String C, int n1, int n2, int n3, int dp[][][])
    {
        if(n1 == 0 || n2 == 0 || n3 == 0) return 0;
        if(dp[n1][n2][n3] != 0) return dp[n1][n2][n3];
        if(A.charAt(n1 - 1) == B.charAt(n2 - 1) && B.charAt(n2 - 1) == C.charAt(n3 - 1)){
            return dp[n1][n2][n3] = 1 + LCSof3(A, B, C, n1 - 1, n2 - 1, n3 - 1, dp);
        } else{
            return dp[n1][n2][n3] = Math.max(LCSof3(A, B, C, n1 - 1, n2, n3, dp),
                    Math.max(LCSof3(A, B, C, n1, n2 - 1, n3, dp),
                            LCSof3(A, B, C, n1, n2, n3 - 1, dp)));
        }
    }

}
