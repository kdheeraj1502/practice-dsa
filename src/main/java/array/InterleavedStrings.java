package array;

public class InterleavedStrings {
    public static boolean isInterLeave(String a,String b,String c)
    {
        if(a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if(c.isEmpty()) return false;
        if(a.isEmpty()) return false;
        if(b.isEmpty()) return false;
        boolean aFlag = false;
        boolean bFlag = false;

        if(c.charAt(0) == a.charAt(0)){
            if(!aFlag && isInterLeave(a.substring(1), b, c.substring(1))){
                aFlag = true;
            }
        }
        if(c.charAt(0) == b.charAt(0)){
            if(!bFlag && isInterLeave(a, b.substring(1), c.substring(1))){
                bFlag = true;
            }
        }
        return aFlag || bFlag;
    }

    public static void main(String[] args) {
        String A = "XY";
        String B = "X";
        String C = "XXY";

        System.out.println(isInterLeave(A, B, C));
    }
}
