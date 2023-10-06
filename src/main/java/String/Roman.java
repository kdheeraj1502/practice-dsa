package String;

public class Roman {
    public int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                // int res=0;
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
                // return res;
            } else {
                return res + s1;
            }


        }
        return res;
    }

    int value(char d1) {
        if (d1 == 'I') {
            return 1;
        }
        if (d1 == 'V') {
            return 5;
        }
        if (d1 == 'X') {
            return 10;
        }
        if (d1 == 'L') {
            return 50;
        }
        if (d1 == 'C') {
            return 100;
        }
        if (d1 == 'D') {
            return 500;
        }
        if (d1 == 'M') {
            return 1000;
        }
        return -1;

    }
}