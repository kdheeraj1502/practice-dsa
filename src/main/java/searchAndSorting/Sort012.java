package searchAndSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort012 {

    public static void sort(int input[]){

        int start = 0;
        int end = input.length - 1;
        int mid = 0;
        while(mid <= end    ){
            if(input[mid] == 0){
                swap(mid, start, input);
                mid++;
                start++;
            }
            else if(input[mid] == 2){
                swap(mid, end, input);
                end--;
            } else{
                mid++;
            }
        }
    }
    private static void swap(int i, int j, int input []){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args) {
        int input  [] = { 0,1,0,0,2,0,1,1 };
        sort(input);
        System.out.println(Arrays.toString(input));
        String str = "abaab";
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                list.add(str.substring(i, j + 1));
            }
        }
        System.out.println(list);
        int count = 0;
        for(String word : list){
            int start = 0;
            int end = word.length() - 1;
            boolean flag = true;
            while (start < end){
                if(word.charAt(start)!=word.charAt(end)){
                    flag = false;
                }
                start++;
                end--;
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }
}
