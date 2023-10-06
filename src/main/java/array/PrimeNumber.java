package array;

public class PrimeNumber {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
// 6K +/- 1
        int i = 5;
        for (i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int N) {
        if (N <= 1)
            return 2;
        int prime = N;
        boolean found = false;
        while (!found) {
            prime++;
            if (isPrime(prime))
                found = true;
        }
        return prime;
    }

    public static void main(String[] args) {
      //  for (int i = 30; i < 100; i++) {
            System.out.println(nextPrime(22));
     //   }
    }
}
