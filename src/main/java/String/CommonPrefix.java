package String;

public class CommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // Return an empty string if the array is empty or null.
        }

        String prefix = strs[0]; // Initialize with the first string

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Check if the current string does not start with the current prefix.
                prefix = prefix.substring(0, prefix.length() - 1); // Remove the last character.
                if (prefix.isEmpty()) {
                    return ""; // If the prefix becomes empty, there's no common prefix.
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strings1 = {"flower", "flow", "flight"};
        String[] strings2 = {"dog", "racecar", "car"};

        System.out.println("Example 1: " + longestCommonPrefix(strings1)); // Output: "fl"
        System.out.println("Example 2: " + longestCommonPrefix(strings2)); // Output: ""
    }
}
