package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

	static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);
		int result = 0;
		int n = c.length;
		int d = n / k;
		int r = n % k;
		for (int i = 0; i < n; i++) {
			if ((i + 1) <= r) {
				result += c[i] * (d + 1);
			} else {
				result += c[i] * d;
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
		int result = getMinimumCost(k, arr);
		System.out.println("Result : " + result);
	}

}
