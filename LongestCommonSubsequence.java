package DSAndAlgo;

public class LongestCommonSubsequence {
    private static int[][] t;

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "afb8cxd";

        System.out.println("Longest Common Subsequence : " + findLongestCommonSubsequence(str1, str2));

    }

    private static int findLongestCommonSubsequence(String str1, String str2) {
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
                if (Character.compare(str1.charAt(i - 1), str2.charAt(j - 1)) == 0) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return t[n1][n2];
    }
}
