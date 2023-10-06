package String;

public class TransformString {
   static int transform (String A, String B)
    {
        int n = A.length();
        int m = B.length();

        if(n != m)
            return -1;

        int[] aux = new int[256]; // charactr, letter, numbers

        for(int i = 0; i < n; i++) {
            char chA = A.charAt(i);

            char chB = B.charAt(i);

            aux[chA]++;
            aux[chB]--;
        }

        for(int i = 0; i < aux.length; i++) {
            if(aux[i] != 0)
                return -1;
        }

        int i = n - 1, j = m - 1;
        int count = 0;
        while(i >= 0) {
            if(A.charAt(i) != B.charAt(j)) {
                count++;
                i--;
            } else {
                i--;
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "abd";
        String B = "bad";
        System.out.println(transform(A, B));
    }
}
