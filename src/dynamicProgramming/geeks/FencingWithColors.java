/*Given a fence with n posts and k colors, 
find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. 
*/
package dynamicProgramming.geeks;

public class FencingWithColors {

	static long calculate(int n, int k) {
		// long total[] = new long[n + 1];
		long total;
		long same;
		long diff;

		same = 0;
		diff = k;
		total = same + diff;

		for (int i = 2; i <= n; i++) {
			same = diff;
			diff = total * (k - 1);
			total = same + diff;
		}

		return total;
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 2;

		System.out.println(calculate(n, k));
	}

}
