class NumberOfIsland{
    private static int maxRow;
    private static int maxCol;
    public static void main(String[] args){
        int arr[][] = { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        maxRow = arr.length;
        maxCol = arr[0].length;
        System.out.print("Number of Islands are : "+ printNumberOfIslands(arr,maxRow,maxCol));

    }

    private static int printNumberOfIslands(int[][] arr, int row, int col) {
        boolean[][] visited = new boolean[row][col];
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==1 && visited[i][j]==false){
                    DFS(arr, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void DFS(int[][] arr, int row, int col, boolean[][] visited) {

        int[] rowNumber = {-1,-1,-1,0,0,1,1,1};
        int[] colNumber = {-1,0,1,-1,1,-1,0,1};

        visited[row][col] = true;

        for(int k = 0; k<rowNumber.length;k++){
            if(notVisitedYetAndSafe(arr, row+rowNumber[k], col+colNumber[k], visited)){
                DFS(arr, row+rowNumber[k], col+colNumber[k], visited);
            }
        }
    }

    private static boolean notVisitedYetAndSafe(int[][] arr, int r, int c, boolean[][] visited) {
        return (r>=0&&r<maxRow && c>=0&&c<maxCol && arr[r][c]==1 && visited[r][c]==false);
    }

}