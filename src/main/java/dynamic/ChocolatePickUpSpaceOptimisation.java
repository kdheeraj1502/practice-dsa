package dynamic;

public class ChocolatePickUpSpaceOptimisation {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int prev[][] = new int[c][c];
        for(int alice = 0; alice < c; alice++){
            for(int bob = 0; bob < c; bob++) {
                if(alice == bob){
                    prev[alice][bob] = grid[r - 1][alice];
                } else{
                    prev[alice][bob] = grid[r - 1][alice] + grid[r - 1][bob];
                }
            }
        }

        for(int row = r - 2; row >= 0; row--){
            int curr[][] = new int[c][c];
            for(int alice = 0; alice < c; alice++){
                for(int bob = 0; bob < c; bob++) {
                    int max = Integer.MIN_VALUE;
                    for(int i = -1; i < 2; i++){
                        for(int j = -1; j < 2; j++){
                            int value = 0;
                            if(alice == bob){
                                value = grid[row][alice];
                            } else{
                                value = grid[row][alice] + grid[row][bob];
                            }
                            if(alice + i < c && alice + i >= 0 && bob + j < c && bob + j >= 0)
                                value += prev[alice + i][bob + j];
                            else
                                value += Integer.MIN_VALUE;
                            max = Math.max(max, value);
                            curr[alice][bob] = max;
                        }
                    }
                }
            }
            prev = curr;
        }
        return prev[0][c - 1];
    }
}
