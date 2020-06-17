package DSAndAlgo;

public class MinimumDeletionToPalindrome {
    public static void main(String[] args) {
        String str1 = "agbcba";

        LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence();
        int lpsLength = LongestPalindromeSubsequence.findLPSLength(str1);

        System.out.println("Minimum # of deletion required:" + (str1.length() - lpsLength));
    }
}
