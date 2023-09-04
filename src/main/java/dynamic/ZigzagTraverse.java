package dynamic;

import java.util.*;

public class ZigzagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        int row = 0, col = 0;
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        boolean goingDown = true;
        while(!isOutOfBound(row, col, height, width)){
            int val = array.get(row) != null ? array.get(row).get(col) : -1;
            result.add(val);
            if(goingDown){
                if(col == 0 || row == height){
                    goingDown = false;
                    if(row == height){
                        col += 1;
                    } else{
                        row += 1;
                    }
                } else{
                    row += 1;
                    col -= 1;
                }
            } else{
                if(row == 0 || col == width){
                    goingDown = true;
                    if(col == width){
                        row += 1;
                    } else{
                        col += 1;
                    }
                } else{
                    row -= 1;
                    col += 1;
                }
            }
        }

        return result;
    }

    private static boolean isOutOfBound(int row, int col,
                                        int height, int width){
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) {

        List<List<Integer>> array = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 3, 4, 10);
        List<Integer> list2 = Arrays.asList(2, 5, 9, 11);
        List<Integer> list3 = Arrays.asList(6, 8, 12, 15);
        List<Integer> list4 = Arrays.asList(7, 13, 14, 16);

        List<Integer> list5 = Arrays.asList(1, 2, 3, 4, 5);
   //     array.add(list1);
     //   array.add(list2);
       // array.add(list3);
     // array.add(list4);

        array.add(list5);

        System.out.println(zigzagTraverse(array));
    }
}
