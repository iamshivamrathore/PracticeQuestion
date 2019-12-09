

package part1.dynamicProgramming.geeks;

import java.time.Duration;
import java.time.LocalDateTime;

public class Catalan {

	static long recursiveCatalan(long n) {
		if (n <= 1) {
			return 1;
		}

		long res = 0;

		for (int i = 0; i < n; i++) {
			res += recursiveCatalan(i) * recursiveCatalan(n - i - 1);
		}

		return res;

	}

	static long recursiveCatalanWithStorage(long n, long arr[]) {
		if (n <= 1) {
			return 1;
		}

		long res = 0;
		if (arr[(int) n] == 0) {
			for (int i = 0; i < n; i++) {
				res += recursiveCatalanWithStorage(i, arr) * recursiveCatalanWithStorage(n - i - 1, arr);
			}
			arr[(int) n] = res;
		}

		return arr[(int) n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 20;
		LocalDateTime time1 = LocalDateTime.now();

		System.out.println(recursiveCatalan(i));

		LocalDateTime time2 = LocalDateTime.now();
		Duration duration = Duration.between(time1, time2);
		System.out.println("Time : " + duration.toMillis());
		
		long arr[] = new long[i + 1];
		System.out.println(recursiveCatalanWithStorage(i, arr));

		time1 = LocalDateTime.now();
		duration = duration.between(time2, time1);
		System.out.println("Time : " + duration.toMillis());
	}

}
