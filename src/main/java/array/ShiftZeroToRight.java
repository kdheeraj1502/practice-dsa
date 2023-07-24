package array;

import java.util.Arrays;

public class ShiftZeroToRight {
    public static int[] shiftZeroToRight(int nums[]){
        int a = 0;
        int b = 0;
        while(a < nums.length && b < nums.length){
            if(nums[b] != 0){
                swap(nums, a, b);
                a++;
                b++;
            } else{
                b++;
            }
        }
        return nums;
    }

    private static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]) {
        int nums[] = { 0, 1, 0, 3, 0, 9, 9, 9, 7, 5, 3, 12, 45, 8, 0, 0, 0, 12 };
        System.out.println(Arrays.toString(shiftZeroToRight(nums)));
    }
}
