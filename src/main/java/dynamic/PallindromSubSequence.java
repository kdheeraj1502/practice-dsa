package dynamic;

public class PallindromSubSequence {
    static void countPS(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int left = 0, right = gap; left < dp.length && right < dp[0].length; left++, right++) {
                if (gap == 0) {
                    dp[left][right] = 1;
                } else {
                    if (s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = 2 + dp[left + 1][right - 1];
                    } else {
                        dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                    }
                }
            }
        }

        System.out.println(dp[0][s.length() - 1]);
    }

    public static void main(String[] args) {
        String str = "where";
        countPS(str);
    }
}
