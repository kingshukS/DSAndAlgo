package DSAndAlgo;

public class MinmNumberOfInsertionToPalindrome {
    public static void main(String[] args) {
        String str = "ABECDBA";
        System.out.println("Minimum # of insertion required : " + findMinimumNumberOfInsertionToPalindrome(str));
    }

    private static int findMinimumNumberOfInsertionToPalindrome(String str) {
        LongestPalindromeSubsequence longestPalindromeSubsequence = new LongestPalindromeSubsequence();
        int lpsLength = LongestPalindromeSubsequence.findLPSLength(str);
        return str.length() - lpsLength;
    }
}
