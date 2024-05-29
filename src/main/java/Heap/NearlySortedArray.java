package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4 };
        System.out.println(isKSortedArray(arr , arr.length, 2));
    }


    private static String isKSortedArray(int arr[], int n, int k)
    {
        int[] aux = Arrays.copyOfRange(arr , 0, n);

        Arrays.sort(aux);


        for(int i = 0; i< n ; i++){

            int j = Arrays.binarySearch(aux , arr[i]);

            if(Math.abs(i-j)>k){
                return "NO";
            }
        }
        return "YES";

    }
}


