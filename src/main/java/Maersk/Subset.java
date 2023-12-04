package Maersk;

import java.util.HashSet;

public class Subset {

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1,2};

       boolean isSubset =  isSubset(arr1, arr2);
       if(isSubset){
           System.out.println("it is subset");
       } else {
           System.out.println("not a subset");
       }
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {

        HashSet<Integer> set = new HashSet<>();

        for(int i : arr1){
            set.add(i);
        }

        for(int i : arr2){
            if(!set.contains(i)){
                return false;
            }
        }

        return true;
    }
}
