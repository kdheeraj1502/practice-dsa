package bit.manupulation;

public class BitDifference {
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        System.out.print(flippedCount(a, b));
    }

    private static int flippedCount(int a, int b) {
        /**
         * xor kardo dono ka, isase pta chalega ki dono me kab kab 1 or 0 tha
         * Jiase ki 10 hota hai => 1010 or 20 hota hai 10100 agar dono ka xor karenge to jana janah 1 and 0 hoga dono me
         * ek me 1 hoga and ek me 0 hoga ya fir vise versa to dono ka xor nikalega
         *  1010
         * 10100
         * -----
         * 11110 => matlab chaar jaga difference hai to 4 jagah flip karna padega
         *
         */
        int xor = a ^ b;
        int count = 0;
        while(xor > 0){
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }
}
