/*Given a 3 x n board, find the number of ways to fill it with 2 x 1 dominoes.*/

package part1.dynamicProgramming.geeks;

public class TillingWithDominoes {

	static int ways(int n) {

		int A[] = new int[n + 1];
		int B[] = new int[n + 1];

		A[0] = 1;
		A[1] = 0;
		B[0] = 0;
		B[1] = 1;

		for (int i = 2; i <= n; i++) {
			A[i] = A[i - 2] + 2 * B[i - 1];
			B[i] = B[i - 2] + A[i - 1];
		}

		for (int i = 0; i < B.length; i++) {
			System.out.print(A[i]+"  ");
		}
		return A[n-n%2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\n"+ways(4));
	}

}
