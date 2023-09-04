package dynamic;

public class MinimumPathSumMemoisation {

    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        return minSumPath(n - 1, m - 1, grid, dp);
    }

    public static int minSumPath(int row, int col, int[][] grid, int dp[][]) {
        if(row == 0 && col == 0) {
            return dp[row][col] = grid[row][col];
        }
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        if(dp[row][col] != 0) return dp[row][col];
        int up = minSumPath(row - 1, col, grid, dp);
        int left = minSumPath(row, col - 1, grid, dp);
        return dp[row][col] = (Math.min(up, left) + grid[row][col]);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };

        System.out.println(minSumPath(grid));
    }
}
