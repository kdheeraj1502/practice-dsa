package String;

public class LongestPalindromSubstring_1 {
    static void printSubStr(String str, int low, int high) {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }
/// forgeeksskeegfor
    static int longestPalSubstr1(String str) {
        int maxLength = 1, start = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                int flag = 1;
                System.out.println(" i is : " + i + " and j is : " + j);
                for (int k = 0; k < (j - i + 1) / 2; k++){
                    System.out.println(" k is : " + k + " And " + "j - i is " + " j = " + j + ", i = " + i + " [ " + (j - i) + " ]");
                    System.out.println("i + k is : " + (i + k) + " And j - k is : " + (j - k));
                    if (str.charAt(i + k)!= str.charAt(j - k))
                        flag = 0;
                }
                if (flag != 0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        System.out.println();
        System.out.println(" ============================================== ");
        System.out.print("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);
        System.out.println();
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aacabdkacaa";
        System.out.println();
        System.out.println("Length is: " + longestPalSubstr(str));
    }


    static int longestPalSubstr(String str) {
        String longest = "";
        int n = str.length();
        int j;
        String subs = "";
        String subsrev = "";
        for (int i = 0; i < n; i++) {
            j = n - 1;
            while (i < j) {
                if (str.charAt(i) == str.charAt(j)
                        && longest.length() < (j - i + 1)) {
                    subs = str.substring(i, j + 1);
                    subsrev = new StringBuilder(subs)
                            .reverse()
                            .toString();
                    if (subs.equals(subsrev)) {
                        longest = subs;
                    }
                }
                j--;
            }
        }
        if (longest.length() == 0) {
            longest = str.substring(0, 1);
        }
        System.out.println(
                "Longest palindrome substring is: " + longest);

        // Return length of LPS
        return longest.length();
    }
}
