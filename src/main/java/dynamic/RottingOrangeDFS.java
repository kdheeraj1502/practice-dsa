package dynamic;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangeDFS {
        public static int orangesRotting(int[][] grid) {

            int row = grid.length;
            int col = grid[0].length;

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 2)
                        dfs_orange(grid, i,j,0,true);
                }
            }

            int sol = 0;

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 1)
                        return -1;

                    sol = Math.min(sol, grid[i][j]);
                }
            }

            return -sol;
        }

        public static void dfs_orange(int[][] grid, int i, int j, int count, boolean rotten) {

            if(i<0 || i>=grid.length ||j<0 || j>=grid[0].length || grid[i][j] == 0 || grid[i][j] < 0 && grid[i][j] > -count)
                return;

            if(grid[i][j] == 2 && !rotten)
                return;

            grid[i][j] = -count;

            dfs_orange(grid, i+1, j, count+1, false);
            dfs_orange(grid, i, j + 1, count+1, false);
            dfs_orange(grid, i - 1, j, count+1, false);
            dfs_orange(grid, i, j-1, count+1, false);
        }



    public static void main(String[] args) {
        int grid[][] = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }
}