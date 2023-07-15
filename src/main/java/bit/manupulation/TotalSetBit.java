package bit.manupulation;

public class TotalSetBit {

    public static int countSetBits(int n) {

        if (n == 0) return 0;
        int x = powerOf2(n);
        int numberUntillPower2 = (x * (1 << (x - 1)));
        int second = n - (1 << x) + 1;
        int last = n - (1 << x);
        return numberUntillPower2 + second + countSetBits(last);
    }

    private static int powerOf2(int n) {
        int x = 0;
        while ((1 << x) <= n) {
            x++;
        }
        return x > 0 ? x - 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(4));
    }
}
