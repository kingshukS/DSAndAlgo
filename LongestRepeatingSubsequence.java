package DSAndAlgo;

public class LongestRepeatingSubsequence {
    public static int[][] t;

    public static void main(String[] args) {
        String s = "AABEBCDDFLF";

        System.out.println("Longest Repeating Subsequence Length : " + findLogestRepeatingSubsequence(s));
    }

    private static int findLogestRepeatingSubsequence(String s) {
        if (s == null || s.length() == 0 || s.equals(""))
            return 0;
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
        return t[n][n];
    }
}
