package Maersk;

public class ReverseWordsString {
    public static void main(String[] args) {
        String S = "I.am...dheeraj";
        String ans = reverseWords(S);

        System.out.println(ans);
    }

    static String reverseWords(String S)
    {

        String[] str = S.split("\\.");
        for(int i =0 ; i< str.length; i++){

            str[i] = reverseString(str[i]);

        }
        String ans = String.join(".", str);
        int dotCount = findTrailingDots(S);
        if(S.endsWith(".")){
            for (int i = 1; i <=dotCount; i++) {
               ans =  ans.concat(".");
            }
        }
        return ans;
    }


    static String reverseString(String s){
        char[] ch = s.toCharArray();
        int low = 0 ;
        int high = ch.length-1;

        while(high> low){

            char temp = ch[low];
            ch[low] = ch[high];
            ch[high] = temp;
            low++;
            high--;
        }

        return new String(ch);
    }
    static int findTrailingDots(String input) {
        int lastIndex = input.length() - 1;

        // Iterate from right to left until a non-dot character is encountered
        int dotCount = 0;
        for (int i = lastIndex; i >= 0; i--) {
            if (input.charAt(i) == '.') {
                dotCount++;
            } else {
                break; // Stop when a non-dot character is encountered
            }


        }
        return dotCount;
    }
}
