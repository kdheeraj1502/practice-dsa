package dynamic;

public class MinPathSumTriangleSpaceOptimisation {
    public static int minimumPathSum(int[][] triangle, int n) {
        int prev[] = new int[n];
        for(int j = n - 1; j >= 0; j--){
            prev[j] = triangle[n - 1][j];
        }
        for(int i = n - 2; i >= 0; i--){
            int curr[] = new int[n];
            for(int j = i; j >= 0; j--){
                int down = prev[j];
                int diagonal = prev[j + 1];
                curr[j] = Math.min(down, diagonal) + triangle[i][j];
            }
            prev = curr;
        }
        return prev[0];
    }
}
