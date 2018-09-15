package algorithms.strings;

import java.util.Scanner;

public class MakingAnagrams {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		int res = makeAnagram(a, b);
		System.out.println(res);
	}

	private static int makeAnagram(String a2, String b2) {

		int a[] = new int[26];
		int b[] = new int[26];

		int l1 = a2.length();
		int l2 = b2.length();

		int min, max;

		int count = 0;

		if (l1 < l2) {
			max = l2;
			min = l1;
		} else {
			min = l2;
			max = l1;
		}

		for (int i = 0; i < min; i++) {
			a[a2.charAt(i) - 97]++;
			b[b2.charAt(i) - 97]++;
		}
		if (l1 < l2) {
			for (int i = min; i < max; i++) {
				b[b2.charAt(i) - 97]++;
			}
		} else {
			for (int i = min; i < max; i++) {
				a[a2.charAt(i) - 97]++;
			}
		}

		for (int i = 0; i < 26; i++) {
		//	System.out.print(a[i] + " " + b[i]);
			count += Math.abs(a[i] - b[i]);
		//	System.out.println();
		}
		return count;
	}
}
