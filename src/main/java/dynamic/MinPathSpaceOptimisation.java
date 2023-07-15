package dynamic;

public class MinPathSpaceOptimisation {
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int prev[] = new int[m];
        for(int i = 0; i < n; i++){
            int curr[] = new int[m];
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0) curr[j] = grid[i][j];
                else{
                    int up = 0, left = 0;
                    if(i > 0) up = prev[j];
                    else up = Integer.MAX_VALUE;

                    if(j > 0) left = curr[j - 1];
                    else left = Integer.MAX_VALUE;

                    curr[j] = Math.min(up, left) + grid[i][j];
                }
            }
            prev = curr;
        }
        return prev[m - 1];
    }
}
