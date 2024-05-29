package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RankNumber {

    public static void main(String[] args) {
        int[] arr = {2, 20, 10, 3, 14, 16, 14};
        replaceWithRank(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }

    static int[] replaceWithRank(int arr[], int N) {



        HashMap<Integer, Integer> map = new HashMap<>();


        int[] aux = Arrays.copyOf(arr , N);

        Arrays.sort(aux);

        int rank = 1;
        for(int i = 0; i<N; i++){
            if(!map.containsKey(aux[i])){
                map.putIfAbsent(aux[i] , rank++);
            }

        }

        for(int i =0; i<N ; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}


