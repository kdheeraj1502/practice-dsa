package java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;

public class SumOfAllNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 4, 10, 12, 87, 33, 75);
  //      LongSummaryStatistics sumL = numbers.stream().mapToLong(x -> x).summaryStatistics();
        IntSummaryStatistics sum = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(sum);
   ///     System.out.println(sumL);
    }
}
