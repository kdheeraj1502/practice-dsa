package array;

import java.util.*;
import java.util.stream.Collectors;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int start = 0;
        int end = array.size() - 1;
        while(start <= end){
            if(array.get(start) != toMove){
                start++;
            }
            if(array.get(end) == toMove){
                end--;
            } else if(array.get(start) == toMove && array.get(end) != toMove){
                Collections.swap(array, start, end);
                start++;
                end--;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(2);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(2);
        System.out.println(moveElementToEnd(array, 2));
    }
}
