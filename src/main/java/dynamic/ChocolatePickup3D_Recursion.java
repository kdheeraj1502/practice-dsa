package dynamic;

public class ChocolatePickup3D_Recursion {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        return maximumChocolates(0, 0, c - 1, r, c, grid);
    }

    public static int maximumChocolates(int row, int col1, int col2, int r, int c, int[][] grid) {
        if(row < 0 || col1 < 0 || col2 < 0 || row >= r || col1 >= c || col2 >= c)
            return Integer.MIN_VALUE;
        if(row == r - 1){
            if(col1 == col2){
                return grid[row][col1];
            } else{
                return grid[row][col1] + grid[row][col2];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int alice = -1; alice < 2; alice++){
            for(int bob = -1; bob < 2; bob++){
                int value = 0;
                if(col1 == col2){
                    value = grid[row][col1];
                } else{
                    value = grid[row][col1] + grid[row][col2];
                }
                value += maximumChocolates(row + 1, col1 + alice, col2 + bob, r, c, grid);
                max = Math.max(max, value);
            }
        }
        return max;
    }
}
