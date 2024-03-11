package String;

public class MaxOddNumberSubString {
   static String maxOdd(String s) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int currMax = 0;
        int max = 0;
        // 530079100
        while(i < s.length()) {
            if(s.charAt(i) % 2 != 0) {
                sb.append(s.charAt(i++));
            } else{
                if(sb.length() > 0) {
                    currMax = Integer.valueOf(sb.toString());
                    max = Math.max(max, currMax);
                    sb = new StringBuilder();
                }
                i++;
            }
        }
        return String.valueOf(max);
    }

    public static void main(String[] args) {
        String s = "9";
        System.out.println(maxOdd(s));
    }
}
