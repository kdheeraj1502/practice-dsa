package dynamic;

public class MinPathSumTriangleTabulation {

    public static int minimumPathSum(int[][] triangle, int n) {
        int dp[][] = new int[n][n];
        for(int j = n - 1; j >= 0; j--){
            dp[n - 1][j] = triangle[n - 1][j];
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
