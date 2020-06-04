package DSAndAlgo;

public class EggDroppingProblem {
    private static int[][] t;

    public static void main(String[] args) {
        int eggs = 3;
        int floors = 9;

        System.out.println("Minimum Number of trials required in worst case : " + eggDrop(eggs, floors));
    }

    private static int eggDrop(int eggs, int floors) {
        t = new int[eggs + 1][floors + 1];
        int res;
        for (int i = 0; i <= eggs; i++) {
            for (int j = 0; j <= floors; j++) {
                if (i == 1)
                    t[i][j] = j;
                if (j == 0 || j == 1)
                    t[i][j] = j;
                if (i == 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                t[i][j] = Integer.MAX_VALUE - 1;
                for (int x = 1; x <= j; x++) {
                    res = 1 + Math.max(t[i - 1][x - 1], t[i][j - x]);
                    t[i][j] = Math.min(res, t[i][j]);
                }
            }
        }
        return t[eggs][floors];
    }
}
