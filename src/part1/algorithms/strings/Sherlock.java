package part1.algorithms.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Sherlock {
	private static final Scanner scanner = new Scanner(System.in);

	static String isValid(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		// System.out.println(map);
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		Set<Character> keys = map.keySet();
		Iterator<Character> iterator = keys.iterator();
		for (int i = 0; i < map.size(); i++) {
			char ch = iterator.next();
			if (numMap.containsKey(map.get(ch))) {
				numMap.put(map.get(ch), numMap.get(map.get(ch)) + 1);
			} else {
				numMap.put(map.get(ch), 1);
			}
		}
		// System.out.println(numMap);
		int numMapSize = numMap.size();
		if (numMapSize == 1) {
			return "YES";
		} else {
			if (numMapSize == 2) {
				Iterator<Integer> iterator1 = numMap.values().iterator();
				Iterator<Integer> iterator2 = numMap.keySet().iterator();
				if ((iterator1.next() == 1 || iterator1.next() == 1)
						&& Math.abs(iterator2.next() - iterator2.next()) == 1) {
					return "YES";
				}

			}
		}
		return "NO";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter String to be processed: ");
		String s = scanner.nextLine();
		scanner.close();
		System.out.println(isValid(s));
	}

}
