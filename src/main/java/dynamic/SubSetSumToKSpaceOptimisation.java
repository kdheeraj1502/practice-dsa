package dynamic;

public class SubSetSumToKSpaceOptimisation {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean prev[] = new boolean[k + 1];
        prev[0] = true;
        if(arr[0] <= k){
            prev[arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            boolean curr[] = new boolean[k + 1];
            curr[0] = prev[0];
            for(int w = 1; w <= k; w++){
                boolean pick = false;
                if(w >= arr[i]) pick = prev[w - arr[i]];
                boolean notPick = prev[w];
                curr[w] = pick || notPick;
            }
            prev = curr;
        }
        return prev[k];
    }
}
