package recursion;

import java.util.*;

class AddNumberInAll {
    public static int addition(int input[], int constant, int index){
        if(input.length <= index){
            return 0;
        } else{
            input[index] = addition(input,constant, index + 1);
            return input[index] + constant;
        }
    }
    public static void main(String args[]){
        int input[] = { 1, 2, 3, 4, 5, 6, 7,8, 9, 10 };
        System.out.println("Before :" + Arrays.toString(input));
        addition(input, 10, 0);
        System.out.println("After " + Arrays.toString(input));
    }
}