package algorithms.random;

import java.util.Scanner;

public class AppleAndOrange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		in.close();
		int app_count = 0;
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple[apple_i] = in.nextInt();
			if (a + apple[apple_i] >= s && a + apple[apple_i] <= t) {
				app_count++;
			}
		}
		int[] orange = new int[n];
		int orange_count = 0;
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange[orange_i] = in.nextInt();
			if (b + orange[orange_i] >= s && b + orange[orange_i] <= t) {
				orange_count++;
			}
		}
		System.out.println(app_count);
		System.out.println(orange_count);
	}
}
