package part1.algorithms.random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Making_Anagrams {

    static int makingAnagrams(String s1, String s2){
        // Complete this function
        int ans = 0;
		char arr1[] = s1.toCharArray();
		char arr2[] = s2.toCharArray();
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		int l = arr1.length > arr2.length ? arr1.length : arr2.length;
		for (int i = 0; i < l; i++) {
			if (i < arr1.length) {
				if (!map1.containsKey(arr1[i])) {
					map1.put(arr1[i], 1);
				} else {
					map1.put(arr1[i], map1.get(arr1[i])+1);
				}
			}
			if (i < arr2.length) {
				if (!map2.containsKey(arr2[i])) {
					map2.put(arr2[i], 1);
				} else {
					map2.put(arr2[i], map2.get(arr2[i])+1);
				}
			}
		}
		Set<Character> set1 = map1.keySet();
		Set<Character> set2 = map2.keySet();

		Iterator<Character> it1 = set1.iterator();
		while (it1.hasNext()) {
			char c = it1.next();
			if(!map2.containsKey(c)){
				ans += map1.get(c);
			}else{
				int count1 = map1.get(c);
				int count2 = map2.get(c);
				
				ans += Math.abs(count1-count2);
				map1.put(c, 0);
				map2.put(c, 0);
			}

		}
		
		it1 = set2.iterator();
		while (it1.hasNext()) {
			char c = it1.next();
			if(!map1.containsKey(c)){
				ans += map2.get(c);
			}else{
				int count1 = map1.get(c);
				int count2 = map2.get(c);
				
				ans += Math.abs(count1-count2);
				map1.put(c, 0);
				map2.put(c, 0);
			}

		}
	//	System.out.println(map1);
	//  System.out.println(map2);
		return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        in.close();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
