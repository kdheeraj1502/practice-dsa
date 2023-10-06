package array;

import java.util.*;

public class CountSort {
    public static void main(String[] args) {
        char[] arr = { 'g', 'e', 't', 'k', 's', 'f', 'o', 'r', 'm', 'z', 'p' };

        // e, e, e, e, f, g, g, ,

        CountSort c = new CountSort();
        c.sort(arr);
        System.out.println("Sorted character array is ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+",");
        System.out.println();
        System.out.println("------------------------------------------------------ ");
        int[] arr1 = { -5, -10, 0, -3, 8, 5, -1, 10 };
        c.countSort(arr1);
        for (int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ,");
    }

    private void sort(char[] arr) {

        int size = arr.length;
        int count[] = new int[256];
        char[] output = new char[size];
        Arrays.fill(count, 0);

        for (int i = 0; i < size; i++) { // to fill the count array
            count[arr[i]]++;
        }

    //    {  4 + 0, 1 + 4, 2 + 5, 1 + 7, 0 + 8, 0 + 8, 0 + 8, 2 + 8, 4 + 10, 2 + 14, 0 }
   //     { 0, 0, 0, 4, 5, 7, 8, 8, 8, 8, 8, 8, 13, 0, 0 , 0 , 0 , 0 }

        for (int i = 1; i < count.length; i++) { // to find the position of each character in the array
            count[i] += count[i - 1];
        }
        // 0,  5, 7, 7, 7, 8, 9,9, 9, 9, 10, 10,10,11, 12


        //e, e, e, e,               k,            11 - s   12 -S

        for (int i = size - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
           // count[arr[i]]--;
        }

        for (int i = 0; i < size; i++) {
            arr[i] = output[i];
        }
    }

    private void countSort(int[] arr) {
     //   { -5, -10, 0, -3, 8, 5, -1, 10 };
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++; //  { 1, 2, 2, 2, 3, 4, 3, 4};
        }
       // 10 - (-10) => 20 ==> 8

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
