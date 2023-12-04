package Maersk;

public class Atoi {

    public static void main(String[] args) {

        String s = "    42";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {

        int idx =0;
        int sign = 1;
        int res = 0;
        //remove leading whitespace

        while(idx < s.length() && s.charAt(idx) == ' '){
            idx++;
        }

        if(idx<s.length() && (s.charAt(idx) == '-' ||s.charAt(idx) == '+' )){
            sign = s.charAt(idx++) == '-' ? -1 : 1;
        }

        while(idx< s.length() && Character.isDigit(s.charAt(idx))){
            int digit = s.charAt(idx) - '0';
            if(res> Integer.MAX_VALUE/10 || (res== Integer.MAX_VALUE/10 && digit> 7) ){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            res = res*10 + digit;
            idx++;
        }

        return res*sign;
    }
}
