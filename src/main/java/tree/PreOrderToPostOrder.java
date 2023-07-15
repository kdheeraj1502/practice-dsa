package tree;

public class PreOrderToPostOrder {
    static int index = 0;
    static void findPostOrderUtil(int pre[], int n, int minval, int maxval) {
        if (index == n)
            return;
        if (pre[index] < minval || pre[index] > maxval) {
            return;
        }
        int val = pre[index];
        index++;
        findPostOrderUtil(pre, n, minval, val);
        findPostOrderUtil(pre, n, val, maxval);
        System.out.print(val + " ");
    }
    static void findPostOrder(int pre[], int n) {
        findPostOrderUtil(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String args[]) {
        int pre[] = {40, 30, 35, 80, 100};
        int n = pre.length;
        findPostOrder(pre, n);
    }
}
