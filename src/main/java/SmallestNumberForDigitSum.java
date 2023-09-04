public class SmallestNumberForDigitSum {
    static void smallestNumber(int N)
    {
        System.out.println(Math.pow(10, (N / 9)));
        System.out.println(N % 9 + 1);
        System.out.print((N % 9 + 1) *
                Math.pow(10, (N / 9)) - 1);
    }

    // Driver code
    public static void main(String[] args)
    {
        int N = 34;
        smallestNumber(N);
    }
}
