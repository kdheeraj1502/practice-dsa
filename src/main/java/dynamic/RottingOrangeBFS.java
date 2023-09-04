package dynamic;

import java.util.*;

public class RottingOrangeBFS {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i= 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    fresh++;
                } else if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int timeCount = 0;
        if(fresh == 0) return 0;
        int dir[][] = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        boolean changed = false;
        while(!queue.isEmpty()){
            timeCount++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr[] = queue.poll();
                for(int j = 0; j < dir.length; j++){
                    int axis[] = dir[j];
                    int x = curr[0] + axis[0];
                    int y = curr[1] + axis[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.offer(new int[] { x, y });
                        changed = true;
                    }
                }
            }
        }
        return changed ? timeCount - 1 : -1;
    }

    public static void main(String[] args) {
        int grid [][]= {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(orangesRotting(grid));
    }
}
