package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumSwaps {

	static int minimumSwaps(int[] arr) {

		int swaps = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] != 8) {
				map.put(arr[i], i);
			} else if(arr.length == 7){
				arr[i] = 7;
				map.put(7, i);
			}
		}

		System.out.println(map);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("No : " + arr[i]);
			if (arr[i] != (i + 1)) {
				int temp = arr[i];
				System.out.print("Looking for : " + (i + 1));
				int pos = map.get((i + 1));

				arr[i] = arr[pos];
				arr[pos] = temp;
				map.put(arr[pos], pos);
				swaps++;
			}
			System.out.println(" " + map);
		}

		displayArray(arr);
		return swaps;
	}

	static void displayArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		minimumSwaps(arr);
		s.close();
	}

}
