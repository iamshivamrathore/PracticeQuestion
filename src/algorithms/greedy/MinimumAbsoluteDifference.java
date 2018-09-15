package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifference {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = minimumAbsoluteDifference(arr);

		System.out.println(result);

	}

	private static int minimumAbsoluteDifference(int[] arr) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int i = 0;i<arr.length-1;i++) {
			if(min > Math.abs(arr[i]- arr[i+1])) {
				min = Math.abs(arr[i]-arr[i+1]);
			}
		}
		
		return min;
	}

}
