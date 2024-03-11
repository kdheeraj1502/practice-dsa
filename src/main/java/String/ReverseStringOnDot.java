package String;

public class ReverseStringOnDot {

    public static String reverseWords(String S) {
        String[] str = S.split("\\.");
        for (int i = 0; i < str.length; i++) {
            str[i] = reverseString(str[i]);
        }
        StringBuilder sb = new StringBuilder();
        int countS = 0;
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '.') {
                countS++;
            } else {
                while(countS > 0){
                    sb.append(".");
                    countS--;
                }
                if(j < str.length){
                    sb.append(str[j++]);
                    i = sb.length() - 1;
                }
            }
        }
        return sb.toString();
    }

    static String reverseString(String s) {
        char[] ch = s.toCharArray();
        int low = 0;
        int high = ch.length - 1;
        while (high > low) {
            char temp = ch[low];
            ch[low] = ch[high];
            ch[high] = temp;
            low++;
            high--;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        System.out.println(reverseWords(S));
    }
}
