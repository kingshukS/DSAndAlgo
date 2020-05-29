public class PrintAllSubsets {

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};
        printAllSubsets(arr);
    }

    private static void printAllSubsets(int[] arr) {
        for(int i=0; i<=arr.length;i++){
            boolean[] ifPrint = new boolean[arr.length];
            printAllSubsets(arr,ifPrint,0,i);

        }
    }

    private static void printAllSubsets(int[] arr, boolean[] ifPrint, int start, int remain) {

        if(remain==0){
            System.out.print("{");
            for(int i =0;i<ifPrint.length;i++){
                if(ifPrint[i])
                    System.out.print(arr[i]+",");
            }
            System.out.println("}");

        }
        else{

            if(start+remain>arr.length)
                ;
            else{
                for(int i = start;i<arr.length;i++){
                    if(!ifPrint[i]){
                        ifPrint[i]=true;
                        printAllSubsets(arr,ifPrint,i+1,remain-1);
                        ifPrint[i]=false;
                    }
                }
            }
        }
    }
}
