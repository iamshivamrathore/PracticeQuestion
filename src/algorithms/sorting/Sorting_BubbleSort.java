package algorithms.sorting;

import java.util.Scanner;

public class Sorting_BubbleSort {

	static void countSwaps(int[] a) {
		int n = a.length;
		int swaps = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(a[j+1]<a[j]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swaps++;
				}
			}
		}
		for(int i:a) {
			System.out.print(i+" ");
		}
		String str = "Array is sorted in %d swaps.";
		System.out.println(String.format(str, swaps).trim());
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[n-1]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		  int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] a = new int[n];

	        String[] aItems = scanner.nextLine().split(" ");
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int i = 0; i < n; i++) {
	            int aItem = Integer.parseInt(aItems[i]);
	            a[i] = aItem;
	        }

	        countSwaps(a);

	        scanner.close();
	}

}
