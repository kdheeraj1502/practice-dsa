package String;

public class ReverseWords {

    public static void main(String[] args) {
        String s= "this is an amazing program";
        //o/p : program amazing an is this

        String[] str = s.split(" ");
        int i = 0;
        int j = str.length-1;
        StringBuilder ans = new StringBuilder();
       while(i<j){
           String temp = str[i];
           str[i] = str[j];
           str[j] = temp;
           i++;
           j--;

       }

        for (String value : str) {
            ans.append(value).append(" ");
        }

        System.out.println(ans);
    }
}
