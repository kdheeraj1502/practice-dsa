package array;

import java.util.Arrays;

public class SortedSquaredArray {
    public static int[] sortedSquaredArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int index = array.length - 1;
        while(start <= end){
            int first = array[start] * array[start];
            int second = array[end] * array[end];
            if(first >= second){
                array[index--] = first;
                start++;
            } else{
                array[index--] = second;
                end--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int array[] = { -2, -1 };
        System.out.println(Arrays.toString(sortedSquaredArray(array)));
    }
}
