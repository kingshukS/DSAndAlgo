package DSAndAlgo;

public class SegregateZeroOne {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 1, 1, 0, 1};
        sortArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void sortArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            while (arr[start] == 0) {
                start++;
            }

            while (arr[end] == 1) {
                end--;
            }
            if (start <= end) {
                arr[start] = 0;
                start++;
                arr[end] = 1;
                end--;
            }
        }
    }
}
