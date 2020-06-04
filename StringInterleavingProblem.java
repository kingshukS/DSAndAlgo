package DSAndAlgo;

public class StringInterleavingProblem {

    private static boolean[][] t;

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "afc";
        String str3 = "aabfcc";

        System.out.println("Interleaving? : " + isInterleaving(str1, str2, str3));

    }

    private static boolean isInterleaving(String str1, String str2, String str3) {
        int n1 = str1.length();
        int n2 = str2.length();
        int n3 = str3.length();
        if (n1 + n2 != n3) {
            return false;
        }

        t = new boolean[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {

                if (i == 0 && j == 0) {
                    t[i][j] = true;
                } else if (i == 0) {
                    if (Character.compare(str2.charAt(j - 1), str3.charAt(j - 1)) == 0)
                        t[i][j] = t[i][j - 1];
                } else if (j == 0) {
                    if (Character.compare(str1.charAt(i - 1), str3.charAt(i - 1)) == 0)
                        t[i][j] = t[i - 1][j];
                } else if (Character.compare(str1.charAt(i - 1), str3.charAt(i + j - 1)) == 0 &&
                        Character.compare(str2.charAt(j - 1), str3.charAt(i + j - 1)) != 0) {
                    t[i][j] = t[i - 1][j];
                } else if (Character.compare(str1.charAt(i - 1), str3.charAt(i + j - 1)) != 0 &&
                        Character.compare(str2.charAt(j - 1), str3.charAt(i + j - 1)) == 0) {
                    t[i][j] = t[i][j - 1];
                } else if (Character.compare(str1.charAt(i - 1), str3.charAt(i + j - 1)) == 0 &&
                        Character.compare(str2.charAt(j - 1), str3.charAt(i + j - 1)) == 0) {
                    t[i][j] = t[i][j - 1] || t[i - 1][j];
                }
            }
        }
        return t[n1][n2];
    }
}
