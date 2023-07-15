package dynamic;

import java.util.Arrays;

public class SubSetSumMemoisation {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k + 1];
        for(int[] pp : dp){
            Arrays.fill(pp, -1);
        }
        return subsetSumToK(n - 1, n, k, arr, dp);
    }

    public static boolean subsetSumToK(int index, int n, int k, int arr[], int dp[][]){
        if(index >= n || index < 0) return false;
        if(k == 0) {
            return true;
        }
        if(index == 0) {
            return k == arr[index];
        }
        if(dp[index][k] != -1) return dp[index][k] == 1 ? true : false;
        boolean pick = false;
        if(k >= arr[index]){
            pick = subsetSumToK(index - 1, n, k - arr[index], arr, dp);
        }
        boolean notPick = subsetSumToK(index - 1, n, k, arr, dp);
        dp[index][k] = pick || notPick ? 1 : 0;
        return pick || notPick;
    }
}
