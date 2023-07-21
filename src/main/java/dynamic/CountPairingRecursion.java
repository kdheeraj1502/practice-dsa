package dynamic;

public class CountPairingRecursion {
    static int mod = 1000000007;

    public static long countFriendsPairings(int n) {
        return recursion(n);
    }

    public static long recursion(int n) {
        if (n == 1 || n == 2)
            return n;

        long a = recursion(n - 1);
        long b = (n - 1) * recursion(n - 2);

        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(countFriendsPairings(4));
    }
}
/*
1, 2, 3, 4
1-2, 3, 4
1-3, 2, 4
1-4, 2, 3

2-3, 1, 4
2-4, 1, 3
3-4, 1, 2

1-2, 3-4
1-3, 2-4
1-4, 2-3


 */
