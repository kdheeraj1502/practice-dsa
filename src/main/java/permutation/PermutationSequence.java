package permutation;

public class PermutationSequence {

    public static String getPermutationNew(int n, int k) {
        String nums = "123456789".substring(0, n);
        int fact[] = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        char[] perm = new char[n];

        for (int i = n, j = 0; i > 0; i--, j++) {
            int p = (k - 1) / fact[i - 1];
            perm[j] = nums.charAt(p);
            nums = nums.substring(0, p) + nums.substring(p + 1);
            k = k - p * fact[i - 1];
        }
        return new String(perm);
    }

    public static String getPermutation(int n, int k) {
        char[] chars = new char[n];
        boolean visited[] = new boolean[n];
        int size = factorial(n);
        k--;
        //    1 2 3
        for (int i = 0; i < n; i++) {
            size = size / (n - i);
            int no = k / size;
            int digit = findNumber(no, visited);
            visited[digit - 1] = true;
            chars[i] = (char) (digit + '0');
            k -= no * size;
        }
        return new String(chars);
    }

    private static int findNumber(int no, boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (no == 0)
                    return i + 1;
                no--;
            }
        }
        return 0;
    }

    private static int factorial(int n) {
        int size = 1;
        for (int i = n; i > 1; i--) {
            size *= i;
        }
        return size;
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutationNew(n, k));
    }
}
