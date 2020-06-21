package DSAndAlgo;

public class MatrixChainMultiplication {
    public static int[][] t;
    public static int[][] b;
    static char name;

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int n = arr.length;
        t = new int[n + 1][n + 1];
        b = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println("Minimum Cost in MCM : " + findMCM(arr, 1, n - 1));
        System.out.println("Printing:: ");
        name = 'A';
        printBrackets(1, n - 1, n, b);
    }

    private static void printBrackets(int i, int j, int n, int[][] b) {
        if (i == j) {
            System.out.print(name++);
            return;
        }
        System.out.print("(");
        printBrackets(i, b[i][j], n, b);
        printBrackets(b[i][j] + 1, j, n, b);
        System.out.print(")");
    }

    private static int findMCM(int[] arr, int i, int j) {

        if (i >= j) {
            return 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAns = findMCM(arr, i, k) + findMCM(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (tempAns < min) {
                min = tempAns;
                b[i][j] = k;
            }
        }

        return t[i][j] = min;
    }
}
