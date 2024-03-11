package array;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstLastOccuranceOfDuplicate {
    public static ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int first = -1;
        int last = -1;
        for(int i = 0;i < arr.length; i++){
            if(arr[i]==x){
                if(first == -1){
                    first = i;
                }
                else{
                    last = i;
                }
            }
        }
        if(last == -1){
            last = first;
        }
        list.add(first);
        list.add(last);
        return list;
        }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int x = 5;
        System.out.println(find(arr, x));
    }
}
