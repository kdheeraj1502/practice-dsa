package String;

import java.util.*;

public class NextPermutation {
    static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> result = new ArrayList<>();
        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]){
            i--;
        }
        if(i == -1){
            reverse(arr, 0, arr.length - 1);
            for(int in : arr){
                result.add(in);
            }
            return result;
        }
        int j = arr.length - 1;
        while(j >= 0 && arr[j] <= arr[i]){
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        for(int in : arr){
            result.add(in);
        }
        return result;
    }

    private static void swap(int num[], int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static void reverse(int num[], int i, int j){
        while(i < j){
            int temp = num[i];
            num[i++] = num[j];
            num[j--] = temp;
        }
    }

    public static void main(String[] args) {
       int [] arr = {3, 1, 5, 1};
        System.out.println(nextPermutation(6, arr));
    }
}
