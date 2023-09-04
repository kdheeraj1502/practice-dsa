package dynamic;

import java.util.Arrays;

public class UniquePathMemoization {
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        uniquePaths(m - 1, n - 1, dp);
        return dp[m - 1][n - 1];
    }

    public static int uniquePaths(int row, int col, int dp[][]) {
        if(row < 0 || col < 0) return 0;
        if(row == 0 && col == 0) return 1;
        if(dp[row][col] != 0) return dp[row][col];
        int left = uniquePaths(row - 1, col, dp);
        int right = uniquePaths(row, col - 1, dp);
        return dp[row][col] = left + right;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }
}
