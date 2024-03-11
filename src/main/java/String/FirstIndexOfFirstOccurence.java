package String;

public class FirstIndexOfFirstOccurence {
    public static int strStr(String haystack, String needle) {
        int a = 0;
        int b = 0;
        int first = 0;
        boolean found = false;
        while(a < haystack.length() && b < needle.length()) {
            if(haystack.charAt(a) != needle.charAt(b)) {
                a++;
                b = 0;
                found = false;
            } else {
                if(!found) {
                    first = a;
                    found = true;
                }
                a++;
                b++;
            }
        }

        if(b < needle.length()) return -1;
        else return first;
    }

    public static void main(String[] args) {
        String a = "leetcode";
        String b = "leeto";
        System.out.println(strStr(a, b));
    }
}
