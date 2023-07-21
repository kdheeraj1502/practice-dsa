package dynamic;

import java.util.Vector;

public class CountFriendsPairingUsingMathFormula {
    static Vector<Integer> fact;

    static void preComputeFact(int n) {
        for (int i = 1; i <= n; i++)
            fact.add(fact.elementAt(i - 1) * i);
    }

    // Returns count of ways n people
// can remain single or paired up.
    static int countFriendsPairings(int n) {
        int ones = n, twos = 1, ans = 0;

        while (ones >= 0) {
            ans += fact.elementAt(n) / (twos * fact.elementAt(ones) * fact.elementAt((n - ones) / 2));
            ones -= 2;
            twos *= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        fact = new Vector<>();
        fact.add(1);

        preComputeFact(15);
        int n = 4;

        System.out.print(countFriendsPairings(n) + "\n");
    }
}
