package String;

import java.util.HashMap;

public class IsoMorphicStr {

    public static void main(String[] args) {
        String str1 = "aac";
        String str2 = "xxx";

        boolean ans = isIsomorphic(str1, str2);

        System.out.println(ans);
    }

    private static boolean isIsomorphic(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                char c = map.get(str1.charAt(i));
                if (c != str2.charAt(i)) {
                    return false;

            }   } else if (!map.containsValue(str2.charAt(i))) {
                map.put(str1.charAt(i), str2.charAt(i));
            } else {
                return false;
            }


        }
        return true;
    }
}
