package part1.algorithms.random;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class MissingNumbers {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        SortedMap<Integer, Integer> map1 = new TreeMap<>();
		SortedMap<Integer, Integer> map2 = new TreeMap<>();

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			if (map1.containsKey(x)) {
				map1.put(x, map1.get(x) + 1);
			} else {
				map1.put(x, 1);
			}
		}

		int m = s.nextInt();
		for (int i = 0; i < m; i++) {
			int x = s.nextInt();
			if (map2.containsKey(x)) {
				map2.put(x, map2.get(x) + 1);
			} else {
				map2.put(x, 1);
			}
		}
		
	//	System.out.println(map1);
	//	System.out.println(map2);
		
	//	List <Integer> ans = new ArrayList<>();
		Iterator<Integer> it = map2.keySet().iterator();
		while(it.hasNext()){
			int key = it.next();
			if(map1.containsKey(key)){
				int count = map2.get(key) - map1.get(key);								
				if(count!=0)
				System.out.print(key+" ");
				
			}
		}
		
		s.close();
    }
}