package dynamic;

public class MinPathSumTriangle {
    public static int minimumPathSum(int[][] triangle, int n) {
        return minimumPathSum(0, 0, triangle, n);
    }

    public static int minimumPathSum(int row, int col, int[][] triangle, int n) {
        if(row >= n || col >= n) return Integer.MAX_VALUE;
        if(row == n - 1) return triangle[row][col];
        int up = minimumPathSum(row + 1, col, triangle, n);
        int left = minimumPathSum(row + 1, col + 1, triangle, n);
        return Math.min(up, left) + triangle[row][col];
    }

    public static void main(String[] args) {

    }
}
