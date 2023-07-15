package java8;

import java.util.stream.IntStream;

public class ReduceJAVA8 {

    public static void main(String[] args) {
        int product = IntStream.range(12, 14).reduce((num1, num2) -> num1 * num2).getAsInt();
        int sum = IntStream.range(1, 1).reduce(10, (num1, num2) -> num1 + num2);
        System.out.println(product + ", " + sum);
    }
}
