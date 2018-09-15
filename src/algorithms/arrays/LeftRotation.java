package algorithms.arrays;

import java.io.IOException;
import java.util.Scanner;

public class LeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int temp[] = new int[d];
		int n = a.length;
		
		for(int i=0;i<d;i++) {
			temp[i] = a[i];
		}
		for(int i=0;i<(n-d);i++) {			
			a[i] = a[d+i];
		}
		for(int i= 0;i<d;i++) {
			a[n-d+i] = temp[i];
		}
		return a;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);
	
		for (int i = 0; i < result.length; i++) {
			System.out.print((String.valueOf(a[i])));
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print((String.valueOf(result[i])));

			if (i != result.length - 1) {
				System.out.println(" ");
			}
		}

		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
