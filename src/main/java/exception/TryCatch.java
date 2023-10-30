package exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TryCatch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,1,2,1);

         numbers.stream().min(Integer::compareTo).ifPresent(System.out::println);

    }

}
