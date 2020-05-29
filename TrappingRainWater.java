public class TrappingRainWater {

    public static void main(String[] args){

        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;
        System.out.print("Quantity of water : "+calculateWaterTrapped(arr, n));
    }

    private static int calculateWaterTrapped(int[] arr, int n) {

        int prev = arr[0];
        int prev_index = 0;
        int water = 0;
        int temp = 0;

        for(int i =0; i<n;i++){

            if(arr[i]>prev){
                prev_index = i;
                prev = arr[i];
                temp = 0;
            }else{
                water+= prev-arr[i];
                temp+= prev-arr[i];
            }
        }

        if(prev_index<n-1){
            water-=temp;
            prev = arr[n-1];
            for(int i = n-1; i>=prev_index; i--){

                if(arr[i]>prev){
                    prev = arr[i];
                }else{
                    water+= prev-arr[i];
                }
            }
        }

        return water;
    }
}
