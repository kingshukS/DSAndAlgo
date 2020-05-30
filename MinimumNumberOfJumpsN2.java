package DSAndAlgo;

public class MinimumNumberOfJumpsN2 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 1, 2, 0, 5, 3};
        int n = arr.length;
        System.out.print("Minimum Number Of Jumps Required:" + minimumNumberOfJumpsN2(arr, n));
    }

    private static int minimumNumberOfJumpsN2(int[] arr, int n) {

        int[] jumps = new int[n];

        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if ((i <= (j + arr[j])) && (jumps[j] != Integer.MAX_VALUE)) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }
}
