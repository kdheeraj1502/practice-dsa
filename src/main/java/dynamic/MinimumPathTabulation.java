package dynamic;

public class MinimumPathTabulation {
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else{
                    int up = 0, left = 0;
                    if(i > 0) up += dp[i - 1][j];
                    else up = Integer.MAX_VALUE;
                    if(j > 0) left = dp[i][j - 1];
                    else left += Integer.MAX_VALUE;
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
