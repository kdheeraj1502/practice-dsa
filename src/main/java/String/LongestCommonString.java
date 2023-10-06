package String;

public class LongestCommonString {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String smallest = strs[0];
        for(String s : strs){
            if(smallest.length() > s.length())
                smallest = s;
        }
        boolean isDone = false;
        while(smallest.length() != 0){
            isDone = true;
            int length = smallest.length();
            for(String s : strs){
                if(!s.substring(0,length).equals(smallest.substring(0,length))){
                    isDone = false;
                    break;
                }
            }
            if(isDone){
                return smallest;
            }
            smallest = smallest.substring(0, length - 1);
        }
        return "";
    }

    public static void main(String[] args) {
        String str[] = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(str));
    }
}
