package java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxInArray {

    public static void main(String[] args) {
       int a =  IntStream.of(4, 7, 0, 3, 1, 6, 4, 10, 9).sum();
    //        max().getAsInt();
        System.out.println(a);

        int nums[] = {4, 7, 0, 3, 1, 6, 4, 10, 9};
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println("Max is " + max);

        int secondLargestNumber = Arrays
                .stream(nums).sum();
                //.sorted()
            //   .boxed()
           //    .sorted(Comparator.reverseOrder())
            //    .skip(1).findFirst().get();
           //     .getAsInt();
               // .findFirst()
               // .getAsInt();
               // .get();
        System.out.println("Second Max is " + secondLargestNumber);


        int min = Arrays.stream(nums).min().getAsInt();
        System.out.println(min);

        int result[] = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(result));


        List<Integer> num = Arrays.asList(1, 2, 3, 4);

        int maxi = num.get(0);
        int secondMax = Integer.MIN_VALUE;
        for(int i = 1; i < num.size(); i++){
            if(num.get(i) > maxi){
                secondMax = maxi;
                maxi = num.get(i);
            } else if(num.get(i) < maxi && num.get(i) > secondMax){
                secondMax = num.get(i);
            }
        }

        System.out.println("Max is : " + maxi + " Second Max is " + secondMax);
    }
}
