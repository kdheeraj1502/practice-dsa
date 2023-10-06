package array;

import java.util.Arrays;

public class Minimizeheight2 {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        arr[0] += k;
        arr[n - 1] -= k;
        return Math.abs(arr[n - 1] - arr[0]);
    }

    public static void main(String[] args) {

    }
}
