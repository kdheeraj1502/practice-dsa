package dynamic;

public class MinimumPathSum {
    public static int minSumPath(int[][] grid) {
        return minSumPath(grid.length - 1, grid[0].length - 1, grid);
    }

    public static int minSumPath(int row, int col, int[][] grid) {
        if(row == 0 && col == 0) {
            return grid[row][col];
        }
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        int up = minSumPath(row - 1, col, grid);
        int left = minSumPath(row, col - 1, grid);
        return (Math.min(up, left) + grid[row][col]);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };

        System.out.println(minSumPath(grid));
    }
}
