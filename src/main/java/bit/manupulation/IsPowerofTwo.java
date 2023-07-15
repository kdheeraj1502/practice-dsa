package bit.manupulation;

public class IsPowerofTwo {
    public static boolean isPowerofTwo(long n){
        if(n == 0) return false;
        else
            return (n & (n - 1)) == 0;

    }
}
