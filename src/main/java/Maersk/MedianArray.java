package Maersk;

public class MedianArray {

    public static void main(String[] args) {
        int[] a = {1, 5, 9};
        int[] b = {2,3,6,7};
        int n = 3;
        int m= 4;

        double ans = medianOfArrays(n, m, a , b);
        System.out.println(ans);
    }

    private static double medianOfArrays(int n, int m, int[] a, int[] b) {


        if (m < n) {
            return medianOfArrays(m, n, b, a);
        }

        int low = 0;
        int high = n;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int right1 = cut1 == n ? Integer.MAX_VALUE : a[cut1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : b[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
