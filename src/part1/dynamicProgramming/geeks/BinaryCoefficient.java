/*Compute Binomial Coefficient using Dynamic Programming
A binomial coefficient C(n, k) gives the number of ways, disregarding order, that k objects can be chosen from among n objects; 
more formally, the number of k-element subsets (or k-combinations) of an n-element set.

 C(n, k) = C(n-1, k-1) + C(n-1, k)*/

package part1.dynamicProgramming.geeks;

public class BinaryCoefficient {

	// if k==0 or k==n, return 1;
	static int binCoefficient(int n, int k) {
		int bin[][] = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					bin[i][j] = 1;
				} else {
					bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
				}
			}
		}

		return bin[n][k];
	}

	public static void main(String[] args) {
		System.out.println(binCoefficient(5, 2));
	}

}
