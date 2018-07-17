package algorithms.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GameOfThrones_1 {

	static String gameOfThrones(String s) {
		// Complete this function
		String result = "YES";
		char arr[] = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		Iterator<Character> it = set.iterator();
	//	boolean even = false;
		boolean odd = false;
		while (it.hasNext()) {
			Character c = it.next();
			int count = map.get(c);
			if (count % 2 == 0) {
			//	even = true;
			} else {
				if (odd == true) {
					result = "NO";
					odd = false;
					break;
				}
				odd = true;
			}
		}

		// System.out.println(map);
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = gameOfThrones(s);
		System.out.println(result);
		in.close();
	}
}
