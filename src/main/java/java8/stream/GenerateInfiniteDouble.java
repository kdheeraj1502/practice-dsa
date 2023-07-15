package java8.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class GenerateInfiniteDouble {
    public static void main(String[] args) {
    /**    DoubleStream.iterate(2, i -> i + 1).forEach(
                d -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(d);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }); */

        IntStream.iterate(2, i -> i + 1).forEach(
                d -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println(d);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
