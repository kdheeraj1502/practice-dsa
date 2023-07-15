package dynamic;

public class SubSetSumToKSpaceSpaceOptimisation {
    public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for(int in : arr)
            sum += in;
        if(sum % 2 == 0){
            boolean prev[] = new boolean[sum/2 + 1];
            return canPartition(n - 1, arr, n, sum/2, prev);
        } else{
            return false;
        }
    }

    public static boolean canPartition(int index, int[] arr, int n, int target, boolean prev[]) {
        prev[0] = true;
        if(arr[0] <= target){
            prev[arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            boolean curr[] = new boolean[target + 1];
            for(int j = 1; j <= target; j++){
                boolean notPick = prev[j];
                boolean pick = false;
                if(arr[i] <= j){
                    pick = prev[j - arr[i]];
                }
                curr[j] = pick || notPick;
            }
            prev = curr;
        }
        return prev[target];
    }
}
