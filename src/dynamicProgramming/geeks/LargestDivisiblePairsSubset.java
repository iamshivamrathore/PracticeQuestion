/*Given an array of n distinct elements, find length of the largest subset such that every pair in the subset is such that the 
larger element of the pair is divisible by smaller element.
*/
package dynamicProgramming.geeks;

import java.util.Arrays;

public class LargestDivisiblePairsSubset {

	static int calculateSubset(int arr[]) {
		int n = arr.length;
		int dp[] = new int[n];

		dp[n - 1] = 1;

		for (int i = n - 2; i >= 0; i--) {
			int max = 0;

			for (int j = i + 1; j < n; j++) {
				if (arr[j] % arr[i] == 0) {
					max = Math.max(dp[j], max);
				}
			}

			dp[i] = max + 1;
		}

		return Arrays.stream(dp).max().getAsInt();
	}

	public static void main(String[] args) {
		int arr[] = { 18, 1, 3, 6, 13, 17};
		Arrays.sort(arr);
		System.out.println(calculateSubset(arr));

	}

}
