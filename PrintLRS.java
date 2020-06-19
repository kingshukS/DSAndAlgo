package DSAndAlgo;

public class PrintLRS {
    public static int[][] t;

    public static void main(String[] args) {
        String s = "AABEBCDD";
        System.out.println("Longest Repeating Subsequence : " + printLRS(s));
    }

    private static String printLRS(String s) {
        populateDPMatrix(s);
        int row = t.length - 1;
        int col = t[0].length - 1;

        StringBuilder stringBuilder = new StringBuilder();

        while (row != 0 && col != 0) {
            if (t[row][col] == 1 + t[row - 1][col - 1]) {
                stringBuilder.append(s.charAt(row - 1));
                row--;
                col--;
            } else if (t[row][col] == t[row - 1][col]) {
                row--;
            } else {
                col--;
            }
        }
        return stringBuilder.reverse().toString();
    }

    private static void populateDPMatrix(String s) {
        if (s == null || s.length() == 0 || s.equals("")) {
            return;
        }
        int n = s.length();
        t = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
    }
}
