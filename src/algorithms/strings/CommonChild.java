package algorithms.strings;

import java.util.Scanner;

public class CommonChild {

	static int commonChild(String s1, String s2) {

		int result[][] = new int[s1.length() + 1][s1.length() + 1];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					result[i + 1][j + 1] = result[i][j] + 1;
				} else {
					result[i + 1][j + 1] = Math.max(result[i + 1][j], result[i][j + 1]);
				}
			}
		}
		return result[s1.length()][s1.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.println("Enter first string");
		String s1 = s.nextLine();
		System.out.println("Enter second string");
		String s2 = s.nextLine();
		s.close();
		System.out.println("Ans : " + commonChild(s1, s2));

	}

}
