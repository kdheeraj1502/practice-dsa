package String;

public class SplitBinaryString {
    public static int maxSubStr(String str) {
        int ans = 0;
        //  int ans2 = 0;
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeros++;
            }
            else {
                ones++;
            }
            if (zeros == ones) {
                ans++;
                zeros = 0;
                ones = 0;
            }
        }
        if (zeros != 0 || ones != 0) return -1;
        return ans;
    }

    public static void main(String[] args) {
        String str = "0100110101";
        System.out.println(maxSubStr(str));
    }
}
