package dynamic;

import java.util.Arrays;

public class PartitionEqualSubSetSumMemoisation {
    public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for(int in : arr)
            sum += in;
        if(sum % 2 == 0){
            int dp[][] = new int[n][sum/2 + 1];
            for(int [] pp : dp){
                Arrays.fill(pp, -1);
            }
            return canPartition(n - 1, arr, n, sum/2, dp);
        } else{
            return false;
        }
    }

    public static boolean canPartition(int index, int[] arr, int n, int target, int dp[][]) {
        if(index < 0) return false;
        if(target == 0) return true;
        if(index == 0){
            if(target == arr[index]) return true;
            else return false;
        }
        if(dp[index][target] != -1) return dp[index][target] == 1 ? true : false;
        boolean pick = false;
        if(target >= arr[index]){
            pick = canPartition(index - 1, arr, n, target - arr[index], dp);
        }
        boolean notPick = canPartition(index - 1, arr, n, target, dp);

        dp[index][target] = pick || notPick ? 1 : 0;
        return pick || notPick;
    }
}
