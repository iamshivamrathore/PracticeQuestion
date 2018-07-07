package algorithms;

import java.util.Scanner;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        int max = 0;
        int count = 0;
        for(int i=0;i<ar.length;i++){
            if(ar[i] == max){
                count ++;
            }
            else if(ar[i] > max){
                max = ar[i];
                count = 1;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        in.close();
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
