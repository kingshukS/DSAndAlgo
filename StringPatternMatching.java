package DSAndAlgo;

public class StringPatternMatching {
    public static void main(String[] args) {
        String str1 = "AXZ";
        String str2 = "AABXTRMZS";

        System.out.println("Pattern Matched : " + findMatchingPattern(str1, str2));
    }

    private static boolean findMatchingPattern(String str1, String str2) {
        int lcsLength = new LongestCommonSubsequence().findLongestCommonSubsequence(str1, str2);
        return str1.length() == lcsLength;
    }
}
