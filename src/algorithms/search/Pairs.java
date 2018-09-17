package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n && arr[i] + k <= arr[n - 1]; i++) {

			// System.out.println("No : "+arr[i]);

			if (search(arr, arr[i] + k)) {
				// System.out.println("Found : "+(arr[i]+k));
				count++;
			} else {
				// System.out.println((arr[i]+k)+" not found");
			}
		}
		s.close();
		System.out.println(count);
	}

	static boolean search(int arr[], int search) {
		int l = 0;
		int r = arr.length - 1;
		boolean result = false;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (arr[mid] < search) {
				l = mid + 1;
			} else if (arr[mid] > search) {
				r = mid - 1;
			} else {
				return true;
			}
		}
		return result;
	}
}