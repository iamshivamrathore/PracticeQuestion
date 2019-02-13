package random_problem_solving;

import java.util.Scanner;

public class BreakingTheRecords {

	static int[] breakingRecords(int[] scores) {
		int result[] = new int[2];
		int min = scores[0];
		int max = scores[0];

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
				result[0]++;
			}

			if (scores[i] < min) {
				min = scores[i];
				result[1]++;
			}
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = scanner.nextInt();

		int scores[] = new int[n];

		for (int i = 0; i < n; i++) {
			scores[i] = scanner.nextInt();
		}

		scanner.close();
		int[] result = breakingRecords(scores);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
