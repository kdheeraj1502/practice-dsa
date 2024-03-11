package math;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void main(String[] args) {
        int num = 100;
        List<Integer> result = getPrimeNumber(num);
        System.out.println(result);
    }

    public static List<Integer> getPrimeNumber(int num) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    private static boolean isPrime(int num) {
        if (num != 2 && num % 2 == 0) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
