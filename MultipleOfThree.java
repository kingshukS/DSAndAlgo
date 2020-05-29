public class MultipleOfThree {

    public static void main(String[] args){
        MultipleOfThree m = new MultipleOfThree();
        System.out.println(isMultipleOfThree(23));
        System.out.println(isMultipleOfThree(24));
        System.out.println(isMultipleOfThree(102));


    }

    private static boolean isMultipleOfThree(int n) {

        int oddCont = 0;
        int evenCount = 0;

        if(n<0)
            n=-n;
        if(n==0)
            return true;
        if(n==1)
            return false;

        while(n>0){

            if( (n & 1) !=0 )
                oddCont++;
            if((n & 2) !=0)
                evenCount++;

            n = n >> 2;
        }
        return isMultipleOfThree(Math.abs(oddCont-evenCount));
    }
}
