package String;

public class LongestPalindromSubString {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];

        int maxi = 0, maxj = 0, maxlength = 0;

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; i < dp.length && j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
                if (maxlength < dp[i][j]) {
                    maxlength = dp[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }
        return s.substring(maxi, maxj + 1);
    }
}
