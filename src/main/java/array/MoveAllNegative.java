package array;

import java.util.Arrays;

public class MoveAllNegative {
    // [-13, -5, 11, 4, 50, -42, 11]
    public static int[] separateNegativeAndPositive(int arr[]) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[a] < 0 && arr[b] < 0){
                b++;
                a++;
              long max =   Long.MIN_VALUE;
            }
            else if(arr[b] > 0){
                b++;
            } else{
                int val = arr[b];
                int d = b - 1;
                while(d > a){
                    swap(arr, d, d + 1);
                    d--;
                }
                if((a + 1) < arr.length) {
                    arr[a + 1] = arr[a];
                    arr[a] = val;
                    a++;
                    b++;
                }
            }
        }
        return arr;
    }

    public static void segregateElements(int arr[], int n)
    {
        int result[] = new int[n];
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                result[k++] = arr[i];
            }
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                result[k++] = arr[i];
            }
        }
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { -23, 48, -13, 31, -12, 6, -42, 23, 14, 33, -33, -21, 0, 25, -39, -31 };
       // System.out.println(Arrays.toString(separateNegativeAndPositive(nums)));

        int input[] = { 1, -1, 3, 2, -7, -5, 11, 6 };
        segregateElements(input, 8);
        System.out.println(Arrays.toString(input));
    }
}
