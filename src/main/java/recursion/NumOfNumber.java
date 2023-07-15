package recursion;

public class NumOfNumber {
    public static void main(String[] args) {
        System.out.println(findSum(9));
    }

    private static int findSum(int n) {
        return n == 1 ? 1 : n + findSum(n - 1);
    }
}
