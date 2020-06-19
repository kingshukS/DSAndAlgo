package DSAndAlgo;

public class PrintLCS {
    private static int[][] t;

    public static void main(String[] args) {
        String str1 = "abcdefxxg";
        String str2 = "afb8cxdexxfg";

        System.out.println("Longest Common Subsequence : " + findLongestCommonSubsequence(str1, str2));
    }

    private static String findLongestCommonSubsequence(String str1, String str2) {

        if (str1 == null || str2 == null)
            return "";
        populateLCSMatrix(str1, str2);

        int row = t.length - 1;
        int col = t[0].length - 1;
        StringBuilder lcs = new StringBuilder();

        while (row != 0 && col != 0) {
            if (t[row][col] == 1 + t[row - 1][col - 1]) {
                lcs.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (t[row][col] == t[row - 1][col]) {
                row--;
            } else {
                col--;
            }
        }

        lcs = lcs.reverse();
        return lcs.toString();
    }

    private static void populateLCSMatrix(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        t = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
//        System.out.println(t[n1][n2]);
    }
}
