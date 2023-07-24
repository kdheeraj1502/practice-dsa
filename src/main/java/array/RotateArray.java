package array;

import java.util.Arrays;

public class RotateArray {
    public static int[] rotateArray_right_to_Left(int nums[], int k) {

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    public static int[] rotateArray_Left_to_right(int nums[], int k) {

        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    private static void reverse(int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int nums[] = {9, 6, 15, 3, 24, 2, 1};
        int k = 2; // 3;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(rotateArray_right_to_Left(nums, k)));
        System.out.println(Arrays.toString(rotateArray_Left_to_right(nums, k)));
    }
}
