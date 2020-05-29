public class CountOfSubsetWithGivenDiff {

    public static int[][] t;
    public static void main(String[] args){
        int arr[] = {1,1,2,3};
        int n = arr.length;
        int diff = 1;
        System.out.println(countOfDiffSubsetSum(arr,diff,n));
    }

    public static int countOfDiffSubsetSum(int[] arr, int diff,int n) {
        int sum = 0;
        for(int i:arr)
            sum+=i;
        int sum1 = (sum+diff)/2;
        return subsetSumCount(arr,sum1,n);
    }

    public static int subsetSumCount(int[] arr, int sum1, int n) {
        t = new int[n+1][sum1+1];

        for(int i=0;i<=n;i++){
         for(int j=0;j<=sum1;j++){
             if(i==0)
                 t[i][j]=0;
             if(j==0)
                 t[i][j]=1;
         }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum1;j++){

                if(arr[i-1]>j)
                    t[i][j]=t[i-1][j];
                else{
                    t[i][j]= t[i-1][j]+t[i-1][j-arr[i-1]];
                }
            }
        }
        return t[n][sum1];
    }
}
