public class CoinChangeProblem2 {
    public static int[][] t;
    private static final int INFINITY = Integer.MAX_VALUE-1;

    public static void main(String[] args){
        int[] coin = {1,2,3,5,7};
        int sum =9;
        int n = coin.length;

        System.out.print("Minimum # of coins:"+minimumNumberOfCoins(coin,sum,n));
    }

    private static int minimumNumberOfCoins(int[] coin, int sum, int n) {
        t = new int[n+1][sum+1];
        for(int i =0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j==0)
                    t[i][j]=0;
                if(i==0)
                    t[i][j]=INFINITY;
            }
        }

        for(int i=1;i<=n;i++){
            for(int j =1;j<=sum;j++){
                if(i==1){
                    if(j%coin[0]==0)
                        t[i][j]=j/coin[0];
                    else{
                        t[i][j]=INFINITY;
                    }
                }else{
                    if(coin[i-1]>j)
                        t[i][j]=t[i-1][j];
                    else{
                        t[i][j]=Math.min(t[i][j-coin[i-1]]+1,t[i-1][j]);
                    }
                }
            }
        }
        return t[n][sum];
    }
}
