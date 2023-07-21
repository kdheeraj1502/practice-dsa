package dynamic;

public class Solution {

    public static void main(String[] args) {
        Singleton sig1 = Singleton.Dheeraj;
        Singleton sig2 = Singleton.Dheeraj;
        System.out.println(sig1 == sig2);
    }
}
