package DSAndAlgo;

public class MinimumNumberOfInsDelFromAToB {
    public static void main(String[] args) {
        String a = "heap";
        String b = "pea";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int lcsLength = LongestCommonSubsequence.findLongestCommonSubsequence(a, b);
        System.out.println("Deletion::" + (a.length() - lcsLength));
        System.out.println("Insertion::" + (b.length() - lcsLength));
    }
}
