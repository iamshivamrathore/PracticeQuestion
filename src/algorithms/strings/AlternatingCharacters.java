package algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		String s1 = s.next();
		s.close();
		System.out.println(alternatingCharacters(s1));
	}

	private static int alternatingCharacters(String s1) {
		// TODO Auto-generated method stub

		char arr[] = s1.toCharArray();
		char ch = arr[0];
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == ch) {
				count++;
			} else {
				ch = arr[i];
			}

		}
		return count;
	}

}
