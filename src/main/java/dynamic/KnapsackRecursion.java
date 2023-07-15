public class KnapsackRecursion {
    static int knapSack(int W, int wt[], int val[], int index)
    {
        if (index == 0 || W == 0)
            return 0;
        if (wt[index - 1] > W)
            return knapSack(W, wt, val, index - 1);
        else
            return Math.max(val[index - 1] + knapSack(W - wt[index - 1], wt, val, index - 1),
                    knapSack(W, wt, val, index - 1));
    }
}
