package java8.reduce;

import java.util.Arrays;
import java.util.OptionalInt;

public class Sum {

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int sum = Arrays.stream(queries).reduce((a, b) -> a + b).getAsInt();
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int queries [] = { 3, 2, 1, 2, 6 };
        System.out.println(minimumWaitingTime(queries));
    }
}
