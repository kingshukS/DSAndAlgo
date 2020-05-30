package DSAndAlgo;

public class EqualSumPartition {

    private static boolean[][] t;

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 7, 5};
        int n = arr.length;
        System.out.println(equalSumPartition(arr, n));
    }

    private static boolean equalSumPartition(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0)
            return false;
        else {
            int newSum = sum / 2;
            t = new boolean[n + 1][newSum + 1];
            calculateSubsetSum(arr, newSum, n);
            return t[n][newSum];
        }
    }

    private static void calculateSubsetSum(int[] arr, int sumR, int n) {

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sumR; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sumR; j++) {

                if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }
            }
        }
    }
}
