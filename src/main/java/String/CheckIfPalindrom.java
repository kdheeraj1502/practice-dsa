package String;

public class CheckIfPalindrom {

    public static boolean isPalindrome(String s) {
        String input = s.toUpperCase();
        int start = 0;
        int end = input.length() - 1;
        while(start < end){
            if(!Character.isAlphabetic(s.charAt(start))){
                start++;
                continue;
            }
            if(!Character.isAlphabetic(s.charAt(end))){
                end--;
                continue;
            }
            if(Character.isAlphabetic(s.charAt(start)) != Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(start)) != Character.isDigit(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
