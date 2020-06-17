package DSAndAlgo;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) {
        String str1 = "agbccba";

        System.out.println("Longest Palindromic Subsequence Length:" + findLPSLength(str1));
    }

    public static int findLPSLength(String str1) {
        StringBuilder stringBuilder = new StringBuilder(str1);
        String str2 = stringBuilder.reverse().toString();

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        return LongestCommonSubsequence.findLongestCommonSubsequence(str1, str2);
    }
}
