package part1.algorithms.random;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}