package algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

	static int getMinimumCost1(int k, int[] c) {
		Arrays.sort(c);
		int result = 0;
		int n = c.length;
		int d = n / k;
		int r = n % k;
		System.out.println("d : " + d);
		System.out.println("r : " + r);
		for (int i = 0; i < n; i++) {
			System.out.println("Num : " + c[i]);
			if ((i + 1) <= r) {
				System.out.println("---1");
				result += c[i] * (d + 1);
			} else {
				System.out.println("---2");
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

	private static int getMinimumCost(int k, int[] c) {
		Arrays.sort(c);
		int result = 0;
		for (int i = c.length - 1, index = 0; i >= 0; i--) {
			int coeff = (index ++ / k)+1;
		//	System.out.println("Num : "+c[i]+"  Coefficient : "+coeff);
			result += c[i] * coeff;
		}
		return result;
	}

}
