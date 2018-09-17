package algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTables_IceCreamParlour {

	// Complete the whatFlavors function below.
	// static void whatFlavors(int[] cost, int money) {
	// int costCopy[] = cost.clone();
	// Arrays.sort(cost);
	// for (int i = 0; i < (cost.length / 2) + 1; i++) {
	// // System.out.println("Current : " + cost[i] + " Going to look for : " +
	// (money - cost[i]));
	// int ans = binSearch(cost, money - cost[i], 0, cost.length - 1);
	// // System.out.println("Received from search : " + cost[ans]);
	// // System.out.println("Ans : " + ans);
	// if (ans != -1) {
	// int money1 = -1; //Get position of first element
	// int ans1 = -1; //Get position of element received after searching
	//
	// for (int j = 0; j < costCopy.length; j++) {
	// if (costCopy[j] == cost[i]) {
	// money1 = j;
	// j++;
	// // System.out.println("Found "+);
	// }
	// if (costCopy[j] == cost[ans]) {
	// ans1 = j;
	//
	// }
	// if (money1 != -1 && ans1 != -1) {
	// break;
	// }
	// }
	//
	// //Print small first
	// if(money1>ans1) {
	// money1 = money1+ans1;
	// ans1 = money1-ans1;
	// money1 = money1-ans1;
	// }
	// System.out.println((money1+1) + " " + (ans1+1));
	// break;
	// }
	//
	// }
	//
	// }

	// static int binSearch(int[] arr, int num, int low, int high) {
	// int med = (low + high) / 2;
	//
	// if (num < arr[low] || num > arr[high]) {
	// return -1;
	// }
	// if (arr[med] == num) {
	// return med;
	// } else if (arr[med] > num) {
	// return binSearch(arr, num, low, med);
	// } else {
	// return binSearch(arr, num, med + 1, high);
	// }
	//
	// }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int money = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] cost = new int[n];

			String[] costItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int costItem = Integer.parseInt(costItems[i]);
				cost[i] = costItem;
			}
			// Arrays.sort(cost);
			whatFlavors(cost, money);
		}

		scanner.close();
	}

	private static void whatFlavors(int[] cost, int money) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < cost.length; i++) {
			System.out.println(map);
			if (map.containsKey(money - cost[i])) {
				
				System.out.println(map.get(money-cost[i]) + " " + (i+1));
				break;
			} else {
				map.put(cost[i], (i+1));
			}
		}
	}
}
