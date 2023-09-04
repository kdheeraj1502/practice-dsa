package array;

import java.util.*;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i + 1]){
                int minNum = array[i + 1];
                int maxNum = array[i];
                min = Math.min(minNum, min);
                max = Math.max(maxNum, max);
            }
        }
        if(min == Integer.MAX_VALUE){
            return new int[] {-1, -1};
        }
        int leftIdx = 0;
        while(min > array[leftIdx]){
            leftIdx++;
        }

        int rightIdx = array.length - 1;
        while(max < array[rightIdx]){
            rightIdx--;
        }

        return new int[] {leftIdx, rightIdx};
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19 };
      //  int array[] = { 1, 2 };
        System.out.println(Arrays.toString(subarraySort(array)));
    }
}
