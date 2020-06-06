package DSAndAlgo;

public class LongestCommonSubstring {

    private static int[][] t;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String s1 = "abcdeff";
        String s2 = "abffdeffg";

        System.out.println("Longest Common Substring : " + findLongestCommonSubstring(s1, s2));
    }

    private static int findLongestCommonSubstring(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        t = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    result = Math.max(result, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return result;
    }
}
