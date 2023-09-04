package array;

import java.util.Arrays;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int result[] = new int[3];
        Arrays.fill(result, Integer.MIN_VALUE);
        for(int i = 0; i < array.length; i++){
            if(array[i] > result[2]){
                result[0] = result[1];
                result[1] = result[2];
                result[2] = array[i];
            } else if(array[i] > result[1]){
                result[0] = result[1];
                result[1] = array[i];
            } else if(array[i] > result[0]){
                result[0] = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array[] = { 18, 141, 541 };
        System.out.println(Arrays.toString(findThreeLargestNumbers(array)));
    }
}
