package DSAndAlgo;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 5};
        int n = arr.length;
        int sum = 2;
        System.out.println("New:" + CountOfSubsetWithGivenDiff.countOfDiffSubsetSum(arr, sum, n));
    }
}
