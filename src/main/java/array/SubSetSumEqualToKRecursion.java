package array;

public class SubSetSumEqualToKRecursion {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return subsetSumToK(n - 1, n, k, arr);
    }

    public static boolean subsetSumToK(int index, int n, int k, int arr[]){
        if(index >= n || index < 0) return false;
        if(k == 0) return true;
        if(index == 0){
            return k == arr[index];
        }
        boolean pick = false;
        if(k >= arr[index]){
            pick = subsetSumToK(index - 1, n, k - arr[index], arr);
        }
        boolean notPick = subsetSumToK(index - 1, n, k, arr);
        return pick || notPick;
    }
}
