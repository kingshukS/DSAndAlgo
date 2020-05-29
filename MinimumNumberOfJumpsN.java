public class MinimumNumberOfJumpsN {

    public static void main(String[] args) {
        int[] arr = {1,4,3,1,2,0,5,3};
        int n = arr.length;
        System.out.print("Minimum Number Of Jumps Required:" + minimumNumberOfJumps(arr, n));
    }

    private static int minimumNumberOfJumps(int[] arr, int n) {
        int jump = 1;
        int maxReach = arr[0];
        int steps = arr[0];

        if (arr.length <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;

        for (int i = 1; i < n; i++) {

            if (i == n - 1)
                return jump;

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;

                steps = maxReach - i;
            }
        }
        return -1;
    }
}
