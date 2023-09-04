package array;

import java.util.*;

public class ProductSum {
    public static int productSum(List<Object> array) {
        return productSum1(array, 1);
    }

    public static int productSum(List<Object> array, int multiplier) {
        int sum = 0;
        for(Object element : array){
            if(element instanceof ArrayList){
                sum += productSum((List<Object>) element, multiplier + 1);
            } else
                sum += (int)element;
        }
        return sum * multiplier;
    }
    public static int productSum1(List<Object> array,  int multiplier) {
        int sum = 0;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) instanceof List){
                sum += productSum1((List<Object>)array.get(i), multiplier + 1);
            } else{
                sum += (int) array.get(i);
            }
        }
        return sum * multiplier;
    }


    public static void main(String[] args) {
     //   int array[] = { 5, 2,  { 7, -1}, 3, {6, {-13, 8}, 4 } };

        List<Object> input = new ArrayList<>();
        List<Object> inner1 = new ArrayList<>();
        inner1.add(7);
        inner1.add(-1);

        List<Object> inner3 = new ArrayList<>();
        inner3.add(-13);
        inner3.add(8);

        List<Object> inner2 = new ArrayList<>();
        inner2.add(6);
        inner2.add(inner3);
        inner2.add(4);

        input.add(5);
        input.add(2);

        input.add(inner1);

        input.add(3);
        input.add(inner2);
        System.out.println(productSum(input));
    }
}
