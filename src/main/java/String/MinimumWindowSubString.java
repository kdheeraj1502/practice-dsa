package String;

public class MinimumWindowSubString {

    static int no_of_chars = 256;

    public static String minWindow(String str, String pat) {
            int len1 = str.length();
            int len2 = pat.length();
            if (len1 < len2) {
                System.out.println("No such window exists");
                return "";
            }
            int hash_pat[] = new int[no_of_chars];
            int hash_txt[] = new int[no_of_chars];
            for (int i = 0; i < len2; i++)
                hash_pat[pat.charAt(i)]++;
            int start = 0,
                    start_index = -1,
                    min_len = Integer.MAX_VALUE;
            int count = 0;// ADOBECODEBANC
            for (int j = 0; j < len1; j++) {
                hash_txt[str.charAt(j)]++;
                if (hash_txt[str.charAt(j)]<= hash_pat[str.charAt(j)])
                    count++;
                if (count == len2) {
                    while (hash_txt[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)]
                            == 0) {
                        if (hash_txt[str.charAt(start)] > hash_pat[str.charAt(start)])
                            hash_txt[str.charAt(start)]--;
                        start++;
                    }
                    int len_window = j - start + 1;
                    if (min_len > len_window) {
                        min_len = len_window;
                        start_index = start;
                    }
                }
            }
            if (start_index == -1) {
                System.out.println("No such window exists");
                return "";
            }
            return str.substring(start_index, start_index + min_len);
        }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow_2(String s, String t) {
        int hash_pat [] = new int[256];
        for(char ch : t.toCharArray()){
            hash_pat[ch]++;
        }
        int start = 0;
        int front = -1;
        int len = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int txt_pat [] = new int[256];
        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            txt_pat[ch]++;
            if(hash_pat[ch] >= txt_pat[ch]){
                count++;
            }
            if(count == t.length()){
                while(hash_pat[s.charAt(start)] == 0 || hash_pat[s.charAt(start)] < txt_pat[s.charAt(start)]){
                    if(hash_pat[s.charAt(start)] <= txt_pat[s.charAt(start)]){
                        hash_pat[s.charAt(start)]--;
                    }
                    start++;
                }
                len = j - start + 1;
                if(len < minLen){
                    minLen = len;
                    front = start;
                }
            }
        }
        return front == -1 ? "" : s.substring(front, front + minLen + 1);
    }
}
