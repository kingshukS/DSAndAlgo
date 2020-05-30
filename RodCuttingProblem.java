package DSAndAlgo;

public class RodCuttingProblem {

    public static int[][] t;

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int n = prices.length;
        System.out.print("Maximum value possible:" + getMaxProfit(prices, n));
    }

    private static int getMaxProfit(int[] prices, int n) {
        int N = n;
        int[] length = new int[N];
        for (int i = 0; i < N; i++) {
            length[i] = i + 1;
        }

        t = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (length[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(prices[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                }
            }
        }
        return t[N][N];
    }
}
