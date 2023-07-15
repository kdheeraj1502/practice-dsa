package array;

import java.util.Arrays;

public class Solution {

    public static int[] sortAll(int num[]) {
        int start = 0;
        int end = num.length - 1;
        int j = num.length - 1;
        int result[] = new int[num.length];
        while (start <= end) {
            if ((num[start] * num[start]) < (num[end] * num[end])) {
                result[j--] = num[end] * num[end];
                end--;
            } else {
                result[j--] = num[start] * num[start];
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int input[] = { -10, -6, -3, -1, 2,  4, 5,  };
        System.out.println(Arrays.toString(sortAll(input)));
    }
}
