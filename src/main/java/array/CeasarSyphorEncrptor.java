package array;

public class CeasarSyphorEncrptor {
    public static String caesarCypherEncryptor(String str, int key) {
        char alphabets[] = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int ch = str.charAt(i) - 96;
    //        int ch = 'X' - 64;
            int position = (ch + key - 1) % 26;
            sb.append(alphabets[position]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int key = 2;
        String string = "xyz";
        System.out.println(caesarCypherEncryptor(string, key));
    }
}
