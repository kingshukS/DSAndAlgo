package DSAndAlgo;

public class MinimumSubsetSum {
    static boolean[][] t;

    public static void main(String[] args) {
        int[] arr = {3, 6, 11, 5, 8};
        System.out.println(getMinimumSubsetSum(arr));
    }

    /**
     * This method calculates the minimum difference between subsets.
     * We have to minimize abs(s1-s2). Now s1 and s2 both lies in the range
     * of 0 to sum where sum = sum of all the elements present in the array.
     * so we will have to calculate and minimize (range-2*s1) expression, assuming s1<s2.
     * Also, the range of s1 lies between range/2 to 0, as s1+s2=range and s2=range-s1.
     * @param arr
     * @return
     */
    private static int getMinimumSubsetSum(int[] arr) {
        int range =0;
        int n = arr.length;

        //Calculating the range in which s1 lies
        for(int i: arr){
            range+=i;
        }
        int range1 = range / 2;
        int res = range;
        t = new boolean[n + 1][range1 + 1];
        subsetSum(arr, range1, n);

        // We have to check for the maximum value of s1 in the range of range/2 e.g. sum/2 to 0.
        // Hence, starting from range/2 and we'll have to consider all the n elements. For any t[n][j] = true, where
        // j is maximum

        for (int i = n, j = range1; j >= 0; j--) {
            if (t[i][j] == true) {
                res = range - 2 * j;
                break;
            }

        }
        return res;
    }

    private static void subsetSum(int[] arr, int sum,int n) {

        //base case initialization

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }
        //Choice Diagram code

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - arr[i - 1]];
                }
            }
        }
    }
}
