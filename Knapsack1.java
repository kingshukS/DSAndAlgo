package DSAndAlgo;

/* A Naive recursive implementation of 0-1 Knapsack problem */
class Knapsack1 {

    static int[][] t;

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // Returns the maximum value that can
    // be put in a knapsack of capacity W

    static int knapSack(int W, int[] wt, int[] val, int n) {
        t = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else{
                    t[i][j]=max(val[i - 1] + t[i-1][j - wt[i - 1]],
                            t[i-1][j]);
                }
            }
        }
        // If weight of the nth item is more
        // than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
//        if (wt[n - 1] > W)
//            return knapSack(W, wt, val, n - 1);
//
//            // Return the maximum of two cases:
//            // (1) nth item included
//            // (2) not included
//        else
//            return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
//                    knapSack(W, wt, val, n - 1));
        return t[n][W];
    }

    // Driver program to test above function
    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 160};
        int[] wt = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
/*This code is contributed by Rajat Mishra */
