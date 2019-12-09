package part1.algorithms.random;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class array {
	int c1;
	int c2;
}

public class GridLand_Metro {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int x = s.nextInt();

		/*
		 * int arr[][] = new int[n][2]; for(int i=0; i<n;i++){ arr[i][0] =
		 * Integer.MAX_VALUE; arr[i][1] = Integer.MIN_VALUE;
		 * 
		 * } for(int i=0;i<x;i++){ int r = s.nextInt(); int c1 = s.nextInt(); int c2 =
		 * s.nextInt();
		 * 
		 * if(c1<arr[r-1][0]) arr[r-1][0] = c1;
		 * 
		 * if(c2>arr[r-1][1]) arr[r-1][1] = c2;
		 * 
		 * } int count = 0; for(int i=0; i<n;i++){ //
		 * System.out.print(Arrays.toString(arr[i])); if(arr[i][0] == Integer.MAX_VALUE
		 * || arr[i][1] ==Integer.MIN_VALUE){ count += m; } else{ int count1 = arr[i][0]
		 * - 1; int count2 = m - arr[i][1]; count += count1 + count2; } //
		 * System.out.println("Blocks added : "+count); }
		 */
		
		

		// long count = n*m;

		BigInteger b1 = BigInteger.valueOf(n);
		BigInteger b2 = BigInteger.valueOf(m);
		BigInteger bCount = b1.multiply(b2);

		Map<Integer, List<array>> map = new HashMap<>();
		
		// int nos = 0;
		
		
		for (int i = 0; i < x; i++) {
			int r = s.nextInt();
			int c1 = s.nextInt();
			int c2 = s.nextInt();
			array arr = new array();
			arr.c1 = c1;
			arr.c2 = c2;
			if (!map.containsKey(r)) {
				map.put(r, new ArrayList<>());
			}
			map.get(r).add(arr);
			// System.out.println(map);
		}

		// System.out.println(map);
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int key = it.next();
			List<array> list = map.get(key);
			list.sort(new Comparator<array>() {

				@Override
				public int compare(array o1, array o2) {
					// TODO Auto-generated method stub
					return o1.c1 - o2.c1;
				}

			});
			// System.out.println(list);
			Stack<array> stack = new Stack<>();
			stack.push(list.get(0));
			for (int i = 1; i < list.size(); i++) {
				// if(stack.peek().c2 >= list.get(i).c1){
				// if(stack.peek().c2 <= list.get(i).c2){
				// array ar = stack.pop();
				// ar.c2 = list.get(i).c2;
				// stack.push(ar);
				// }else{
				// stack.push(list.get(i));
				// }
				// }
				if (list.get(i).c1 > stack.peek().c2) {
					stack.push(list.get(i));
				} else {
					if (list.get(i).c2 > stack.peek().c2) {
						array ar = stack.pop();
						ar.c2 = list.get(i).c2;
						stack.push(ar);
					}
				}
			}

			// System.out.println(stack.size());
			while (!stack.isEmpty()) {
				array z = stack.pop();
				// System.out.print("Element : "+z);
				// System.out.print(" count B: "+count);
				// count = count - (z.c2-z.c1+1);
				bCount = bCount.subtract(BigInteger.valueOf(z.c2 - z.c1 + 1));
				// System.out.println(" count A: "+count);
			}

			// int count1 = map.get(key).c1-1;
			// int count2 = m - map.get(key).c2;
			// count +=count1 + count2;
			// System.out.println("key : "+key + " count1 : "+count1 +
			// " count2 : "+count2);
		}

		// System.out.println("CountB : " + count);
		// count += (n - nos) * m;
		System.out.println(bCount);
		s.close();

	}
}