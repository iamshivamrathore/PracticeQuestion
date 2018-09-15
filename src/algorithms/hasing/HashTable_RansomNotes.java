package algorithms.hasing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTable_RansomNotes {
	static void checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < magazine.length; i++) {
			if (map.containsKey(magazine[i])) {
				map.put(magazine[i], map.get(magazine[i]) + 1);

			} else {
				map.put(magazine[i], 1);
			}
		}

	//	System.out.println("Map : "+map);
		for (int i = 0; i < note.length; i++) {
			if (map.containsKey(note[i])) {
				if (map.get(note[i]) > 1) {
					map.put(note[i], map.get(note[i]) - 1);
				} else {
					map.remove(note[i]);
				}
			}
			else {
				System.out.println("No");
				return;
			}
		//	System.out.println("Word : "+note[i] + "\tMap : "+map);
		}
		
		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
