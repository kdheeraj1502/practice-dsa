package dynamic;

public class PartitionEqualSubSetSumRecursion {
    public static boolean canPartition(int[] arr, int n) {
        int sum = 0;
        for(int in : arr)
            sum += in;
        if(sum % 2 == 0){
            return canPartition(n - 1, arr, n, sum/2);
        } else{
            return false;
        }
    }

    public static boolean canPartition(int index, int[] arr, int n, int target) {
        if(index < 0) return false;
        if(target == 0) return true;
        if(index == 0){
            if(target == arr[index]) return true;
            else return false;
        }
        boolean pick = false;
        if(target >= arr[index]){
            pick = canPartition(index - 1, arr, n, target - arr[index]);
        }
        boolean notPick = canPartition(index - 1, arr, n, target);

        return pick || notPick;
    }
}
