package java8.stream;

import java.util.UUID;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        char ch = 'e';
        long a  =   str.chars().filter(c -> ch == c).count();
        System.out.println(a);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
    }
}
