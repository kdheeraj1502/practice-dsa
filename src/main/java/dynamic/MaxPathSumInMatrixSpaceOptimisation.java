package dynamic;

public class MaxPathSumInMatrixSpaceOptimisation {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int prev[] = new int[m];
        for(int col = 0; col < matrix[0].length; col++){
            prev[col] = matrix[0][col];
        }
        for(int i = 1; i < n; i++){
            int curr[] = new int[m];
            for(int j = 0; j < m; j++){
                int up = prev[j];
                int diagonalLeft = Integer.MIN_VALUE;
                if(j > 0) diagonalLeft = prev[j - 1];
                int diagonalRight = Integer.MIN_VALUE;
                if(j + 1 < m) diagonalRight = prev[j + 1];
                int diagonalMax = Math.max(diagonalLeft, diagonalRight);
                curr[j] = Math.max(up, diagonalMax) + matrix[i][j];
            }
            prev = curr;
        }
        for(int col = 0; col < matrix[0].length; col++){
            max = Math.max(max, prev[col]);
        }
        return max;
    }
}
