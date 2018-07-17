package algorithms.random;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLong_Factorials {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.close();
		BigInteger ans = BigInteger.valueOf(N);
		for (int i = N - 1; i >= 1; i--) {
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		System.out.println(ans);
	}
}