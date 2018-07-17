package algorithms.random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NonDivisible_Subset {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
        if(k ==1){
			System.out.println("1");
			s.close();
			return;
		}
		int arr[] = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			int rem = arr[i] % k;
			if (map.containsKey(rem)) {
				map.put(rem, map.get(rem) + 1);
			} else {
				map.put(rem, 1);
			}
		}
		int count = 0;
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int num = it.next();
	//		System.out.println("Num : " + num);
			if (num == 0) {
				count += 1;
				map.put(0, 0);
			} else if (num == k / 2.0f) {
				count += 1;
				map.put(num, 0);
			} else if (map.containsKey(num)) {
				if (map.containsKey(k - num)) {
					count += Math.max(map.get(num), map.get(k - num));
					map.put(num, 0);
					map.put(k - num, 0);
				} else {
					count += map.get(num);
					map.put(num, 0);
				}
			}
		
//		System.out.println(map);
    }
        System.out.println(count);
		s.close();
}}