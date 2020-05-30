package DSAndAlgo;

import java.util.Arrays;

public class NextGreaterNumbertWithSameDigits {
    public static void main(String[] args) {
        int number = 534976;
        System.out.print("Next greater number is : " + findNextGreaterNumber(number));
    }

    private static int findNextGreaterNumber(int number) {
        char[] chars = new Integer(number).toString().toCharArray();
        int n = chars.length;
        int i;

        for (i = n - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                break;
            }
        }

        if(i==0)
            return -1;
        else{
            int x = chars[i-1];
            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (chars[j] > x && chars[j] <= chars[min])
                    min = j;
            }

            swap(chars,i-1,min);
            Arrays.sort(chars,i,n);

            return Integer.parseInt(new String(chars));
        }
    }

    private static void swap(char[] chars, int i, int min) {
        char temp = chars[i];
        chars[i]= chars[min];
        chars[min] = temp;
    }
}
