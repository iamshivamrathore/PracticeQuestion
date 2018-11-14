package random_problem_solving;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClimbingTheLeaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int result[] = new int[alice.length];
		int i = 0;
		int j = scores.length - 1;
		Set<Integer> scoresUnique = new HashSet<>();
		for (int z = 0; z < scores.length; z++) {
			scoresUnique.add(scores[z]);
		}
		int rank = scoresUnique.size();
		rank++;
//		System.out.println("Last Rank : " + rank);
		while (j >= 0 && i<alice.length) {
			
//			System.out.println("\n\nAlice : "+alice[i]);
//			System.out.println("Score : "+scores[j]);
//			System.out.println("Rank : "+rank);
			if (alice[i] < scores[j]) {
				result[i++] = rank;
			} else {
				j--;
				if (j>=0 && scores[j] > scores[j + 1]) {
					rank--;
				}
			}
		}

		while (i < alice.length) {
			result[i++] = 1;
		}
		return result;
	}

	// int binSearch(int arr[], int low, int high, int num) {
	// if (num > arr[low]) {
	// return low;
	// } else if (num < arr[high]) {
	// return high;
	// }
	//
	// int med = (low + high) / 2;
	//
	// if(arr[med] == num) {
	// return med;
	// }
	//
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int scores[] = new int[n];
		for (int i = 0; i < n; i++) {
			scores[i] = s.nextInt();
		}

		int m = s.nextInt();
		int alice[] = new int[m];
		for (int i = 0; i < m; i++) {
			alice[i] = s.nextInt();
		}

		s.close();

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}


//7
//100 100 50 40 40 20 10
//4
//5 25 50 120
