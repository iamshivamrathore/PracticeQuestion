package part1.dynamicProgramming;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Max_Array_Sum {
	static int maxSubsetSum(int[] arr) {

		int[] sol = new int[arr.length];
		sol[0] = arr[0];
		sol[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			sol[i] = Math.max(Math.max(sol[i - 2] + arr[i], sol[i - 1]), arr[i]);
		}
		return sol[sol.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("out.txt"));

			s.close();
			int res = maxSubsetSum(arr);
			pw.write(res + " ");
			System.out.println(res);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
