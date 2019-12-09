package part1.algorithms.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			if (arr[i] - arr[i - 1] <= min) {
				if (arr[i] - arr[i - 1] < min) {
					list.clear();
					min = arr[i] - arr[i - 1];
				}

				// list.clear();
				list.add(arr[i - 1]);
				list.add(arr[i]);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}