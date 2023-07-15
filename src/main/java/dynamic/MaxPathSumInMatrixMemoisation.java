package dynamic;

public class MaxPathSumInMatrixMemoisation {

    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int dp[][] = new int[n][m];
        for(int i = matrix[0].length - 1; i >= 0; i--){
            max = Math.max(max, getMaxPathSum(n - 1, i, matrix, dp));
        }
        return max;
    }

    public static int getMaxPathSum(int row, int col, int[][] matrix, int dp[][]) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) return Integer.MIN_VALUE;
        if(row == 0) {
            return dp[row][col] = matrix[row][col];
        }
        if(dp[row][col] != 0) return dp[row][col];
        int up = getMaxPathSum(row - 1, col, matrix, dp);
        int diagonalLeft = getMaxPathSum(row - 1, col - 1, matrix, dp);
        int diagonalRight = getMaxPathSum(row - 1, col + 1, matrix, dp);
        int diagonalMax = Math.max(diagonalLeft, diagonalRight);
        dp[row][col] = Math.max(up, diagonalMax) + matrix[row][col];
        return dp[row][col];
    }
}
