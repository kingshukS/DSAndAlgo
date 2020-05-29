/* A Naive recursive implementation of 0-1 Knapsack problem */
class SubsetSum {

    // A utility function that returns maximum of two integers
    static boolean compare(boolean a, boolean b) { return a||b; }
    static boolean t[][];
    // Returns the maximum value that can
    // be put in a knapsack of capacity W

    static boolean subsetSum(int arr[], int sum, int n) {
        t=new boolean[n+1][sum+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 )
                    t[i][j] = false;
                if (j == 0 )
                    t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else{
                    t[i][j]=compare(t[i-1][j - arr[i - 1]],
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
        return t[n][sum];
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        int arr[] = new int[] { 10, 2, 30 };
        int sum = 70;
        int n = arr.length;
        System.out.println(subsetSum(arr,sum, n));
    }
}
/*This code is contributed by Rajat Mishra */
