/*Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106*/

package random_problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class Kadane_Algorithm {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = scanner.nextInt();
			}
			int num = calculate(arr);
			System.out.println(num);
		}
		scanner.close();

	}

	private static int calculate(int[] arr) {

		int n = arr.length;
		int out[] = new int[n];
		out[0] = arr[0];
		for (int i = 1; i < n; i++) {
			out[i] = Math.max(out[i - 1] + arr[i], arr[i]);

			
		}

//		for (int i = 0; i < out.length; i++) {
//			System.out.print(out[i] + " ");
//		}
//		System.out.println();
		return Arrays.stream(out).max().getAsInt();
	}

}
