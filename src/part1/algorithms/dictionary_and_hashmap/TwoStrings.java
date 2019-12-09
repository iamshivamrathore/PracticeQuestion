package part1.algorithms.dictionary_and_hashmap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "",s2 =  "";
		Scanner s = new Scanner(System.in);
		s1 = s.next();
		s2 = s.next();
		s.close();
		System.out.println(twoStrings(s1, s2));
		
	}

	private static String twoStrings(String s1, String s2) {
		// TODO Auto-generated method stub
		Set<Character> set = new HashSet<Character>();
		char arr1[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();
		
		for(int i=0;i<s1.length();i++) {
			set.add(arr1[i]);
		}
		
		for(int i=0;i<s2.length();i++) {
			if(set.contains(arr2[i])) {
				return "Yes";
			}
		}
		return "No";
		
	}

}
