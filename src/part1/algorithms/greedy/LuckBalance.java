package part1.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LuckBalance {

	static int luckBalance(int k, int[][] contests) {
		int ans = 0;
		// System.out.println("Length: " + contests.length);
		Comparator<Integer> myComparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if (i1 < i2) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		// Queue<Integer> maxHeap = new PriorityQueue<>(myComparator);
		List<Integer> list = new ArrayList<>();
		// int index = 0;
		for (int i = 0; i < contests.length; i++) {
			if (contests[i][1] == 1) {
				list.add(contests[i][0]);

			} else {
				ans += contests[i][0];
			}
		}
		 System.out.println("0 "+ans);
		int n = list.size();

		
		if (n * Math.log(n) < k * n) {
			Collections.sort(list, myComparator);
			 System.out.println("AAAAAA Entire sort");

		} else {

			for (int i = 0; i < k; i++) {
				int minIndex = i;
				// int min = Integer.MAX_VALUE;
				// Iterator <Integer> it = list.iterator();
				// while(it.hasNext()) {
				// int num = it.next();
				// if(num < min) {
				//
				// }
				// }
				for (int j = 0; j < n; j++) {
					if (list.get(j) > list.get(minIndex)) {
						minIndex = j;
					}
				}

				int temp = list.get(i);
				list.set(i, list.get(minIndex));
				list.set(minIndex, temp);
				// arr[minIndex] = temp;
				System.out.println("In : "+list);
			}

		}
		 System.out.println("List : "+list);
		Iterator<Integer> it = list.iterator();
		int i = 0;
		while (i < k && it.hasNext()) {
			ans += it.next();
			i++;
		}
		System.out.println("  " + ans);
		while (it.hasNext()) {
			// System.out.println("Here:");
			ans -= it.next();
		}
		// for (int i = 0; i < k; i++) {
		// ans += arr[i];
		// }
		// for (int i = k; i < n; i++) {
		// ans -= arr[i];
		// }
		//
		// for (int i = 0; i < k; i++) {
		// System.out.println("No : " + maxHeap.peek());
		// ans += maxHeap.poll();
		// System.out.println(maxHeap);
		// }
		// List<Integer> list = new ArrayList<>();
		// list.addAll(maxHeap);
		// Iterator<Integer> it = list.iterator();
		// while (it.hasNext()) {
		// ans -= it.next();
		// }
		//
		// System.out.println(maxHeap);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int contests[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			contests[i][0] = s.nextInt();
			contests[i][1] = s.nextInt();
		}
		s.close();

		System.out.println(luckBalance(k, contests));
	}

}
