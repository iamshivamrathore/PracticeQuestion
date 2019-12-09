package part1.algorithms.random;

import java.util.Scanner;

public class Sherlock_And_Array {

	static String solve(int[] a) {

		int sum = 0;
		int lSum = 0;
		int rSum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}

		rSum = sum;
		int last;
		// int cur;
		for (int i = 0; i < a.length; i++) {
			last = a[i];
			rSum -= last;

			if (lSum == rSum) {
				return "YES";
			}
			lSum += last;

		}
		return "NO";
		// Complete this function
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			in.close();
			String result = solve(a);
			System.out.println(result);
		}
	}
}
