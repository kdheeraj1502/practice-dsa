public class CoinChange {
    public static long count1(int coins[], int N, int sum) {
        return rec(coins, N - 1, sum);
    }

    public static long rec(int coins[], int index, int sum) {
        if(index == 0){
            if(sum - coins[0] == 0) return 1;
            else return 0;
        }
        if(index < 0) {
            return 0;
        }
        if(sum == 0) {
            return 1;
        }
        if(sum < 0) {
            return 0;
        }

        return rec(coins, index, sum - coins[index]) + rec(coins, index - 1, sum);
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        System.out.println(count2(coins, coins.length, 4));
    }

    static int count2(int coins[], int n, int sum){
        return count(coins, n, sum);
    }
    static int count(int coins[], int n, int sum)
    {
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n == 0){
             return 0;
        }
        return count(coins, n - 1, sum) + count(coins, n, sum - coins[n - 1]);
    }
}
