package recursion;

public class FindFactorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(6));
    }

    private static int findFactorial(int n) {
        return n == 1 ? 1 : n * findFactorial(n - 1 );
    }
}
