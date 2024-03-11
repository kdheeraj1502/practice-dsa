package math;

import java8.stream.A;

import java.util.*;

public class FactorOfNumber {

    public static List<Integer> factors(int num) { //    100
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    result.add(i);
                } else {
                    result.add(i);
                    result.add(num / i);
                }
            }
        }
        return result;
    }


    public static int kthFactor(int n, int k) {
        TreeSet<Integer> result = factors1(n);
        List<Integer> list = new ArrayList<>(result);
        return result.size() >= k ? list.get(k - 1) : -1;
    }

    private static TreeSet<Integer> factors1(int num) {
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == num / i) {
                    result.add(i);
                } else {
                    result.add(i);
                    result.add(num / i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int data = (int) Math.sqrt(89);
        //   System.out.println(data);
        //      int num = 100;
        //       System.out.println(factors(num));

        int n = 24;
        int k = 6;
        //    System.out.println(kthFactor(n, k));

        List<Integer> result = getFactors(89);
        System.out.println(result);
    }


    static List<Integer> getFactors(int num) {
        int i;
        boolean flag = false;
        List<Integer> result = new ArrayList<>();
        for (i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                result.add(i);
            if (i == num / i)
                flag = true;
        }


   //     i  = 11

        if (flag) {
            i -= 2;
        } else {
            i -= 1;
        }

        for (; i >= 1; i--) {
            if (num % i == 0) {
                result.add(num / i);
            }
        }
        return result;
    }
}
