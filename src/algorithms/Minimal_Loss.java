package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Minimal_Loss {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long arr[] = new long[n];
		Map<Long, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextLong();
			map.put(arr[i], i);
		}

		Arrays.sort(arr);
		long min = Long.MAX_VALUE;

		// System.out.println("Map : " + map);
		// System.out.println("Arr : " + Arrays.toString(arr));
		for (int i = 1; i < n; i++) {
			int j = i;

			// System.out.println("Arr[i-1] : " + arr[i - 1] + "\t Arr[i] : "
			// + arr[i]);
			if (arr[i] - arr[i - 1] < min) {
				// System.out.println("Inside 1 min : "+min);
				while (j > 0) {
					if (map.get(arr[i]) < map.get(arr[j - 1]) && arr[i] - arr[j - 1] < min) {
						// System.out.println("2");
						min = -arr[j - 1] + arr[i];
						break;
					} else {
						j--;
					}
				}
			}

		}
		System.out.println(min);
		s.close();
	}
}