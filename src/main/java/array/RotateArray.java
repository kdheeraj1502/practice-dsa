package array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int d = 6;
        int n= 5;
        rotateArr(arr, d, n);

        System.out.println(Arrays.toString(arr));
    }

    static void rotateArr(int[] arr, int d, int n)
    {

        if (arr == null || arr.length == 0 || d < 0 || n <= 0) {
            // Handle invalid input, such as null array, negative d or non-positive n.
            return;
        }
        d = d % n;

        int[] temp = new int[d];

        System.arraycopy(arr, 0, temp, 0, d);

        for(int i = 0; i<n-d; i++){
            arr[i] = arr[i+d];
        }
        int j =0;
        for(int i = n-d ; i< n; i++ ){
            arr[i] = temp[j];
            j++;
        }
    }
}
