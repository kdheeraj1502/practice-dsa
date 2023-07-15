package dynamic;

public class MinPathSumMemoisation {
    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][] = new int[n][n];
        return minimumPathSum(0, 0, triangle, n, dp);
    }

    public static int minimumPathSum(int row, int col, int[][] triangle, int n, int dp[][]) {
        if(row >= n || col >= n) return Integer.MAX_VALUE;
        if(row == n - 1) return dp[row][col] = triangle[row][col];
        if(dp[row][col] != 0) return dp[row][col];
        int up = minimumPathSum(row + 1, col, triangle, n, dp);
        int left = minimumPathSum(row + 1, col + 1, triangle, n, dp);
        dp[row][col] = Math.min(up, left) + triangle[row][col];
        return dp[row][col];
    }
}
