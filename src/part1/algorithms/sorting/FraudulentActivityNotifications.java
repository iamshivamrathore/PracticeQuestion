package part1.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FraudulentActivityNotifications {

	static int activityNotifications(int[] expenditure, int d) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < expenditure.length; i++) {
			map.put(i, expenditure[i]);
		}

		List<Integer> queue = new ArrayList<>();
		// List<Integer> list = new ArrayList<>();
		for (int i = 0; i < d; i++) {
			int num = expenditure[i];

			queue.add(num);
			// list.add(num);
		}

		// int median;

		Collections.sort(queue);
		int arr[] = new int[d];
		for (int i = 0; i < d; i++) {
			arr[queue.get(i)]++;
		}
		for (int i = d; i < expenditure.length; i++) {

			// System.out.print(queue);
			// Collections.sort(queue);

			float median = (d % 2 == 0) ? (float) (queue.get(d / 2) + queue.get((d / 2) - 1)) / 2 : queue.get(d / 2);
			System.out.println(" Median : " + median);

			if (expenditure[i] >= 2 * median) {
				ans++;
			}

			System.out.println(queue + " Remove : " + queue.remove(map.get(i - d)));
			
			System.out.print("Before : " + queue);
			addToList(queue, expenditure[i], d);
			System.out.print(" Inserting : " + expenditure[i]);
			System.out.println(" After : " + queue);
		}

		return ans;
	}

	private static void addToList(List<Integer> queue, int num, int d) {
		int n = queue.size();
		int pos = getPos(queue, num, 0, n - 1);

		queue.add(pos, num);

	}

	private static int getPos(List<Integer> queue, int num, int low, int high) {

		int med = (low + high) / 2;

		if (num >= queue.get(queue.size() - 1)) {
			// System.out.println("------------------0");
			return queue.size();
		}

		if (num <= queue.get(0)) {
			// System.out.println("----------------1");
			return 0;
		}

		if (num > queue.get(med) && num < queue.get(med + 1)) {
			// System.out.println("-----------------2");
			return med + 1;
		} else if (num > queue.get(med + 1)) {
			return getPos(queue, num, med + 1, high);
		} else if (num < queue.get(med) && num > queue.get(med - 1)) {
			return med;
		} else {
			return getPos(queue, num, low, med - 1);
		}
	}

	// private static int getMedian(List<Integer> queue, int d) {
	// // TODO Auto-generated method stub
	// Iterator<Integer> it = queue.iterator();
	// int num = 0;
	// for (int i = 0; i < d / 2; i++) {
	// num = it.next();
	// }
	//
	// return (d % 2 == 0) ? ((num + it.next()) / 2) : it.next();
	//
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = s.nextInt();
		int[] expenditure = new int[n];
		for (int i = 0; i < n; i++) {
			expenditure[i] = s.nextInt();
		}

		System.out.println("Ans : " + activityNotifications(expenditure, d));
	}

}
