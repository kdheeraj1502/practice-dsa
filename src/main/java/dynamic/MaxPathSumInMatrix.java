package dynamic;

public class MaxPathSumInMatrix {
    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for(int i = matrix[0].length - 1; i >= 0; i--){
            max = Math.max(max, getMaxPathSum(n - 1, i, matrix));
        }
        return max;
    }

    public static int getMaxPathSum(int row, int col, int[][] matrix) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[row].length) return Integer.MIN_VALUE;
        if(row == 0) return matrix[row][col];
        int up = getMaxPathSum(row - 1, col, matrix);
        int diagonalLeft = getMaxPathSum(row - 1, col - 1, matrix);
        int diagonalRight = getMaxPathSum(row - 1, col + 1, matrix);
        return Math.max(up, Math.max(diagonalLeft, diagonalRight)) + matrix[row][col];
    }
}
