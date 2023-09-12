package interview;

import java.util.HashSet;
import java.util.Set;

public class ContainsAllAlphabet {

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrstuvwx";

        boolean containsAllAlphabet = containsAllAlphabets(input);
        if(containsAllAlphabet){
            System.out.println("contains");
        } else {
            System.out.println("does not contain");
        }
    }

    private static boolean containsAllAlphabets(String input) {

        Set<Character> set = new HashSet();

        for(Character c : input.toCharArray()){
            if(Character.isLetter(c)){
                set.add(Character.toLowerCase(c));
            }
        }

        return set.size() == 26;
    }
}
