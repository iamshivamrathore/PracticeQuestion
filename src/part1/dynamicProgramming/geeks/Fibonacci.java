package part1.dynamicProgramming.geeks;

import java.time.Duration;
import java.time.LocalDateTime;

public class Fibonacci {

	// Normal recursion
	static long fib1(int n) {
		if (n <= 1)
			return n;
		return fib1(n - 1) + fib1(n - 2);
	}

	// Recursion with storing the results
	static long fib2(int n, long[] arr) {
		if (n <= 1) {
			return n;
		}

		if (arr[n] == 0) {
			arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);
		}
		return arr[n];

	}

	public static void main(String[] args) {
		fib(46);

	}

	private static void fib(int i) {
		// TODO Auto-generated method stub
		LocalDateTime time1 = LocalDateTime.now();

		LocalDateTime time2 = LocalDateTime.now();
		Duration duration = Duration.between(time1, time2);
		// System.out.println("Time : " + Math.abs(duration.toMillis()));

		long arr[] = new long[i + 1];
		arr[0] = 0;
		arr[1] = 1;
		System.out.println("2 : " + fib2(i, arr));
		time1 = LocalDateTime.now();
		duration = Duration.between(time2, time1);
		// System.out.println("Time : " + Math.abs(duration.toMillis()));

		System.out.println("1 : " + fib1(i));
	}

}
