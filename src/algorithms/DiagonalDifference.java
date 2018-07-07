package algorithms;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum1 = 0, sum2 = 0;
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = s.nextInt();
				if (i == j) {
					sum1 += a[i][j];
				}

				if (i + j == n - 1) {
					sum2 += a[i][j];
				}
			}
		}
		s.close();
		int diff = Math.abs(sum1 - sum2);
		System.out.print(diff);
	}
}