package searchAndSorting;

public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {3,1};
        int target = 1;

        System.out.println(search(arr, target));
    }

    private static int search(int[] nums, int target) {
        if(nums.length==2){
            if(nums[0]== target){
                return 0;
            }
            if(nums[1]==target){
                return 1;
            }
        }
        return search(nums, target, 0 , nums.length-1);
    }

    private static int search(int[] arr, int target, int start, int end) {
        if(end<start){
            return -1;
        }

        int mid = (start+end)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid]> arr[start]){
            if(arr[start]<=target && arr[mid]>target){
                return search(arr, target, start, mid-1);
            } else {
                return search(arr, target, mid+1, end);
            }
        } else {
            if(arr[end]>=target && arr[mid]< target){
                return search(arr, target, mid+1, end);
            } else {
                return search(arr, target, start, mid-1);
            }
        }
    }
}
