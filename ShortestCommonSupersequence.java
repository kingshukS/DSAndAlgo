package DSAndAlgo;

public class ShortestCommonSupersequence {
    private static int[][] t;

    public static void main(String[] args) {
        String a = "abdefz";
        String b = "abcdfxy";

        System.out.println("Length of Shortest Common Supersequence : " + lengthOfSCS(a, b));
    }

    private static int lengthOfSCS(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();

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
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int lcsLength = t[n1][n2];

        return a.length() + b.length() - lcsLength;
    }
}
