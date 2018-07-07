package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Mini_Maxi_Sum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(arr);
		long min = 0;
		long max = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			min += arr[i];
			max += arr[i];
		}
		min +=arr[0];
		max +=arr[arr.length-1];
		System.out.println(min+" "+max);
    }
}
