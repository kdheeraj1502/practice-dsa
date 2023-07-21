package bit.manupulation;

import java.lang.reflect.Array;
import java.util.*;

public class Permutation {
    public static List<List<String>> permutation(String num[]) {
        List<List<String>> result = new ArrayList<>();
        permutation(num, result, 0);
        return result;
    }

    public static void permutation(String num[], List<List<String>> result, int index) {
        if (index == num.length) {
            List<String> curr = new ArrayList<>();
            for (String in : num) {
                curr.add(in);
            }
            result.add(curr);
            return;
        }
        for (int i = index; i < num.length; i++) {
            swap(num, i, index);
            permutation(num, result, index + 1);
            swap(num, i, index);
        }
    }

    public static void swap(String num[], int i, int j) {
        String temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        System.out.println(Arrays.toString(num));
    }

    public static void main(String[] args) {
        int num[] = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = i;
        }
        String str[] = { "A", "B", "C" };
        permutation(str).stream().forEach(System.out::println);
        //System.out.println(permutation(num));
    }
}
