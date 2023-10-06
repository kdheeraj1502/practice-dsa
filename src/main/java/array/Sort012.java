package array;

import java.util.Arrays;

public class Sort012 {
    public static void sort012(int arr[])
    {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(mid <= end){
            if(arr[start] == 0){
                start++;
                mid++;
            } else if(arr[end] == 2){
                end--;
            } else{
                if(arr[mid] == 0){
                    swap(arr, mid, start);
                    start++;
                } else if(arr[mid] == 2){
                    swap(arr, mid, end);
                    end--;
                } else{
                    mid++;
                }
            }
        }
    }

    private static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 2, 1, 2, 0 };
        sort012(nums);
        System.out.println(Arrays.toString(nums));
    }
}
