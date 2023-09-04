package dynamic;

public class LongestCommonSubSequenceDP {
    public static int LCS(String x, String y, int m, int n) {
        int dp[][] = new int[x.length() + 1][y.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int len = dp[m][n];
        int i = m;
        int j = n;

        int index = len - 1;
        String output = "";
        for (int k = 0; k < len; k++) {
            output += "$";
        }

        StringBuilder str2 = new StringBuilder(output);

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                str2.setCharAt(index, y.charAt(j - 1));
                index--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else j--;
        }
        System.out.println(str2);

        return dp[m][n];
    }

    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        System.out.println(LCS(x, y, x.length(), y.length()));
    }
}
