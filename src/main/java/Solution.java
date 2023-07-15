import java.util.Arrays;

public class Solution {

    public static void sort(int input [] ){
        int start = 0;
        int end = input.length - 1;
        int mid = 0;

        // 0,1,0,0,2,0,1,1

        while(start < end && mid < input.length){
            if(input[mid] == 0){
                swap(start, mid, input);
                start++;
                mid++;
            }
            if(input[end] == 2){
                end--;
            }
            else if(input[mid] == 1){
                swap(mid, start, input);
                mid++;
            } else{
                swap(mid, end, input);
            }
        }
    }

    private static void swap(int i, int j, int input[]){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int input  [] = { 0,1,0,0,2,0,1,1 };
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
