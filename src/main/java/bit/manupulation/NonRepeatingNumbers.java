package bit.manupulation;

import java.util.Arrays;

public class NonRepeatingNumbers {
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int in : nums) {
            xor ^= in;
        }
        int x = 0, y = 0;
        int set_bit_no = xor & ~(xor - 1);

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & set_bit_no) > 0)
                x = x ^ nums[i];
            else y = y ^ nums[i];
        }
        int result[] = new int[2];
        result[0] = x;
        result[1] = y;
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 2, 1, 4};
        System.out.println(Arrays.toString(singleNumber(arr)));
    }
}
