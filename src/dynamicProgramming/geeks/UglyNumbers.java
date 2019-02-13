/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
By convention, 1 is included.*/

package dynamicProgramming.geeks;

public class UglyNumbers {

	static boolean isUgly(int n) {

		while (n > 0) {
			if (n == 1) {
				return true;
			}

			if (n % 2 == 0) {
				n = n / 2;
			} else if (n % 3 == 0) {
				n = n / 3;
			} else if (n % 5 == 0) {
				n = n / 5;
			} else {
				return false;
			}
		}
		return false;
	}

	static void iterative(int n) {
		int uglyCount = 0;

		int i = 1;
		while (true) {
			if (isUgly(i)) {
				uglyCount++;
			}

			if (uglyCount == n) {
				break;
			}

			i++;
		}

		System.out.println("Ans is :" + i);
	}

	static void dynamic(int n) {
		int ugly[] = new int[n];
		ugly[0] = 1;
		int nextUgly = 1;

		int nextUgly_2 = 0;
		int nextUgly_3 = 0;
		int nextUgly_5 = 0;

		for (int i = 1; i < n; i++) {
			nextUgly = Math.min(ugly[nextUgly_2] * 2, Math.min(ugly[nextUgly_3] * 3, ugly[nextUgly_5] * 5));
			ugly[i] = nextUgly;

			if (nextUgly == ugly[nextUgly_2] * 2) {
				nextUgly_2++;
			}
			if (nextUgly == ugly[nextUgly_3] * 3) {
				nextUgly_3++;
			}
			if (nextUgly == ugly[nextUgly_5] * 5) {
				nextUgly_5++;
			}

		}

		System.out.println("Ugly : " + nextUgly);

	}

	public static void main(String[] args) {
		// iterative(150);

		dynamic(150);

	}
}
