package array;

import java.lang.reflect.Array;
import java.util.*;


 ////  { 4, 2, 3, 6, 7, 8, 1, 9, 5, 10 },
  //  { 12, 19, 15, 16, 20, 18, 13, 17, 11, 14 }

public class SpiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        int sc = 0;
        int sr = 0;
        int ec = array[0].length - 1;
        int er = array.length - 1;
        List<Integer> result = new ArrayList<>();
        while(sr <= er && sc <= ec){
            for(int i = sc; i <= ec; i++){
                result.add(array[sr][i]);
            }
            for(int i = sr + 1; i <= er; i++){
                result.add(array[i][ec]);
            }
            for(int i = ec - 1; i > sc; i--){
                result.add(array[er][i]);
            }
            for(int i = er - 1; i > sr; i--){
                result.add(array[i][sc]);
            }
            sr++;
            ec--;
            er--;
            sc++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] input = {
                {1,  2,   3,  4},
                {10, 11, 12,  5},
                {9,  8,   7,  6}
  };
        System.out.println(spiralTraverse(input));
    }
}
