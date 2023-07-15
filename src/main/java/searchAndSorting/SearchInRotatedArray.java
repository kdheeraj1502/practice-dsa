package searchAndSorting;

public class SearchInRotatedArray {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid])
                return mid;
            else if (nums[mid] > nums[nums.length - 1]) {
                if (target > nums[mid] || target < nums[0]) {
                    low = mid + 1;
                } else
                    high = mid - 1;
            } else {
                if (target < nums[mid] || target > nums[nums.length - 1]) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
