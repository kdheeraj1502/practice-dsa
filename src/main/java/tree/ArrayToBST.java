package tree;

import java.util.Arrays;

public class ArrayToBST {
    static int index = 0;
    public static int[] sortedArrayToBST(int[] nums)
    {
        int[] result = new int[nums.length];
        sortedArrayToBST(result, nums, 0, nums.length - 1);
        return result;
    }

    public static void sortedArrayToBST(int[] result, int[] nums, int start, int end)
    {
        if(start > end) return;
        int mid = (start + end)/2;
        result[index++] = nums[mid];
        sortedArrayToBST(result, nums, start, mid - 1);
        sortedArrayToBST(result, nums, mid + 1, end);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4} ;
        System.out.println(Arrays.toString(sortedArrayToBST(nums)));
    }
}
