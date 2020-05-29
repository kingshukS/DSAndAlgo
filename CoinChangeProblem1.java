
//Total # of ways
public class CoinChangeProblem1 {

    public static int[][] t;
    public static void main(String[] args){
        int[] coin = {1,2,3};
        int sum = 5;
        int n = coin.length;

        System.out.print("Total # of ways:"+maximumNumberOfWays(coin,sum,n));
    }

    private static int maximumNumberOfWays(int[] coin, int sum, int n) {
        t = new int[n+1][sum+1];
        for(int i =0;i<=n;i++){
            for(int j =0;j<=sum;j++){
                if(i==0)
                    t[i][j]=0;
                if(j==0)
                    t[i][j] = 1;
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j=1;j<=sum;j++){

                if(coin[i-1]>j){
                    t[i][j]= t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j]+t[i][j-coin[i-1]];
                }
            }
        }

        return t[n][sum];
    }
}
