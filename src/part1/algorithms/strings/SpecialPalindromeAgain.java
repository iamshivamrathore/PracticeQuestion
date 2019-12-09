package part1.algorithms.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class SpecialPalindromeAgain {
	static class Point {
		char ch;
		long count;

		Point(char c) {
			ch = c;
		}

		public String toString() {
			return ch + "(" + count + ")";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (ch != other.ch)
				return false;
			if (count != other.count)
				return false;
			return true;
		}

	}

	static long returnConsecutiveSum(long length) {
		Map<Long, Long> countMap = new HashMap<Long, Long>();
		long counter = 0;
		if (countMap.containsKey(length)) {
			return countMap.get(length);
		} else {
			for (int i = 1; i <= length; i++) {
				counter += i;
			}
			countMap.put(length, counter);

			return counter;
		}
	}

	static long substrCount(int n, String s) {
		long ans = 0;

		LinkedList<Point> list = new LinkedList<>();
		char ch = '0';
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ch) {
				ch = s.charAt(i);
				Point p = new Point(ch);
				p.count = 1;
				list.add(p);
			} else {
				list.peekLast().count++;
			}
		}
		if (list.size() == 1) {
			return returnConsecutiveSum(list.get(0).count);
		}
		if (list.size() == 2) {
			return (returnConsecutiveSum(list.get(0).count) + returnConsecutiveSum(list.get(1).count));
		}
		Iterator <Point> it = list.iterator();
		Point first = it.next();
		Point second = it.next();
		
		while(it.hasNext()) {

			Point third = it.next();
			ans += returnConsecutiveSum(first.count);
			if (first.ch == third.ch && second.count == 1) {
				// System.out.println("Satisfied : ");
				// System.out.println(first + " " + second + " " + third);
				ans += Math.min(first.count, third.count);
			}
//			if (third.count > 1) {
//				i++;
//			}
			first = second;
			second = third;

		}
		try {
			ans += returnConsecutiveSum(list.get(list.size() - 2).count);
			ans += returnConsecutiveSum(list.get(list.size() - 1).count);
		} catch (Exception e) {
		}
		// System.out.println(list);
		// System.out.println("Ans : " + ans);
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		s.close();
		System.out.println("Ans : " + substrCount(str.length(), str));
	}
}
