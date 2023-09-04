package bit.manupulation;

public class CopySetBits {
    static int copySetBits(int x, int y,
                           int l, int r) {

        if (l < 1 || r > 32)
            return x;

        // get the length of the mask
        int maskLength = (int) ((1L << (r - l + 1)) - 1);

        // Shift the mask to the required position
        // "&" with y to get the set bits at between
        // l ad r in y
        int mask = ((maskLength) << (l - 1)) & y;
        x = x | mask;
        return x;
    }

    // Driver code
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            int mask = 1 << (i - 1);
            System.out.println(mask);
        }

        int x = 10, y = 13, l = 2, r = 3;
        x = copySetBits1(x, y, l, r);
        System.out.print("Modified x is " + x);
    }

    static int copySetBits1(int x, int y,
                           int l, int r)
    {
        // l and r must be between 1 to 32
        // (assuming ints are stored using
        //  32 bits)
        if (l < 1 || r > 32)
            return x;

        // Traverse in given range
        for (int i = l; i <= r; i++)
        {
            // Find a mask (A number whose
            // only set bit is at i'th position)
            int mask = 1 << (i-1);

            // If i'th bit is set in y, set i'th
            // bit in x also.
            if ((y & mask)!=0)
                x = x | mask;
        }

        return x;
    }
}
