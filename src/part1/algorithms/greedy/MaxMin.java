package part1.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	static int maxMin(int k, int[] arr) {

		// System.out.println(" K :" + k);
		int result = Integer.MAX_VALUE;

		Arrays.sort(arr);
		for (int i = 0; i < arr.length - k+1; i++) {
			System.out.println("1 : " + arr[i] + "  2:" + arr[i + k - 1]);
			if (arr[i + k - 1] - arr[i] < result) {
				result = arr[i + k - 1] - arr[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		s.close();
		int response = maxMin(k, arr);
		System.out.println("RES : " + response);
	}

}
