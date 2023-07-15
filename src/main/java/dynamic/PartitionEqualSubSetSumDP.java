package dynamic;

public class PartitionEqualSubSetSumDP {
    public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for(int in : arr)
            sum += in;
        if(sum % 2 == 0){
            boolean dp[][] = new boolean[n][sum/2 + 1];
            return canPartition(n - 1, arr, n, sum/2, dp);
        } else{
            return false;
        }
    }

    public static boolean canPartition(int index, int[] arr, int n, int target, boolean dp[][]) {
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n - 1][target];
    }
}
