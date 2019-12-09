package part1.algorithms.arrays;

import java.util.Scanner;

public class NewYearChaos {

	static void minimumBribes1(int[] arr) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			// System.out.println("Num : "+arr[i]);
			if (arr[i] > (i + 1)) {
				// System.out.println("1");
				int temp = arr[i] - (i + 1);
				if (temp > 2) {
					System.out.println("Too chaotic");
					return;
				} else {
					// System.out.println("2");
					count += temp;
				}
			} else if (arr[i] < (i + 1)) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] < arr[i]) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int num = s.nextInt();
			int arr[] = new int[num];
			for (int j = 0; j < num; j++) {
				arr[j] = s.nextInt();
			}
			minimumBribes(arr);
		}
		s.close();
	}

	static void minimumBribes(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			// System.out.println("Num : "+arr[i]);
			if (arr[i] - (i + 1) > 2) {
				// System.out.println("1");

				System.out.println("Too chaotic");
				return;

			}
		}
		
		int count = 0;
		for(int i=arr.length-1;i>=0;i--) {
			
			for(int j=Math.max(0, arr[i]-2);j<i;j++) {
				if(arr[j]>arr[i]) {
					count ++;
				}
			}
		}
		System.out.println(count);

	}

	static void displayArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void minimumBribes2(int[] arr) {
		// TODO Auto-generated method stub
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			// System.out.println("Num : "+arr[i]);
			if (arr[i] > (i + 1)) {
				// System.out.println("1");
				int temp = arr[i] - (i + 1);
				if (temp > 2) {
					System.out.println("Too chaotic");
					return;
				}
			}
		}

		boolean swapped = false;
		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					System.out.println("In");
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
					swapped = true;
				}
				if (swapped) {
					swapped = false;
				} else {
					break;
				}

			}

			displayArray(arr);
			System.out.println("Sorted : " + swapped);

		}
		System.out.println(count);

	}

}
