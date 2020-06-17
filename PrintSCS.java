package DSAndAlgo;

public class PrintSCS {
    private static int[][] t;

    public static void main(String[] args) {
        String str1 = "facebookabcdefgh";
        String str2 = "spoonabdfklmt";

        System.out.println("Shortest Common Subsequence : " + printSCSAsString(str1, str2));
    }

    private static String printSCSAsString(String str1, String str2) {
        populateLCSMatrix(str1, str2);
        StringBuilder stringBuilder = new StringBuilder();
        int row = t.length - 1;
        int col = t[0].length - 1;

        while (row != 0 && col != 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
//                System.out.println("Adding0.0:"+str1.charAt(row-1));
                stringBuilder.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (t[row - 1][col] > t[row][col - 1]) {
//                System.out.println("Adding0.1:"+str1.charAt(row-1));
                stringBuilder.append(str1.charAt(row - 1));
                row--;
            } else {
//                System.out.println("Adding0.2:"+str2.charAt(col-1));
                stringBuilder.append(str2.charAt(col - 1));
                col--;
            }
        }
        while (row > 0) {
//            System.out.println("Adding1:"+str1.charAt(row-1));
            stringBuilder.append(str1.charAt(row - 1));
            row--;
        }

        while (col > 0) {
//            System.out.println("Adding2:"+str2.charAt(col-1));
            stringBuilder.append(str2.charAt(col - 1));
            col--;
        }

        return stringBuilder.reverse().toString();
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
    }
}
