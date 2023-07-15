package dynamic;

public class MaxPathSumInMatrixDP {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[n][m];
        for(int col = 0; col < matrix[0].length; col++){
            dp[0][col] = matrix[0][col];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int up = dp[i - 1][j];
                int diagonalLeft = Integer.MIN_VALUE;
                if(j > 0) diagonalLeft = dp[i - 1][j - 1];
                int diagonalRight = Integer.MIN_VALUE;
                if(j + 1 < m) diagonalRight = dp[i - 1][j + 1];
                int diagonalMax = Math.max(diagonalLeft, diagonalRight);
                dp[i][j] = Math.max(up, diagonalMax) + matrix[i][j];
            }
        }
        for(int col = 0; col < matrix[0].length; col++){
            max = Math.max(max, dp[n - 1][col]);
        }
        return max;
    }
}
