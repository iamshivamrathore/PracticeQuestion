package algorithms.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IceCream_Parlour {

    public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int j = 0; j < t; j++) {
			int m = s.nextInt();
			int n = s.nextInt();
			int arr[] = new int[n];
			Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
				if (!map.containsKey(arr[i])) {
					map.put(arr[i], new ArrayList<>());
					map.get(arr[i]).add(i);
				} else {
					map.get(arr[i]).add(i);
				}

			}

			Arrays.sort(arr);
		//	System.out.println("Sorted : "+Arrays.toString(arr));
			// System.out.println(Arrays.toString(arr));
			// System.out.println(map) ;
			for (int i = 0; i < n; i++) {
				int index = binSearch(arr, m - arr[i]);
	//			System.out.println("i : "+i+" \t arr[i] : "+arr[i]+"\t index "+index);
				if (index != -1) {

					
					List<Integer> list = map.get(arr[index]);
					List<Integer> list1 = map.get(arr[i]);
					
//					System.out.println("i : "+i+"\t arr[i] : "+arr[i]);
//					System.out.println("index : "+index+"\t arr[index] : "+arr[index]);
//					System.out.println("list : "+list);
//					if (list.size() > 1 && arr[index] == arr[i]) {
//						System.out.println("a");
//						System.out.println((list.get(0) + 1) + " " + (list.get(1) + 1));
//					}
//					// System.out.println("Index : "+index+" arr[i]:"+arr[i] + "
//					// list:" + list);
//					else {
//						System.out.println("b");
//						System.out.println((i + 1) + " " + (list.get(0) + 1));
//					}
//
					
					if(list==list1){
					//	System.out.println("Equals");
						System.out.println((list.get(0)+1) + " " +(list.get(1)+1));
					}else{
						System.out.println(Math.min((list1.get(0)+1), (list.get(0)+1)) + " " +Math.max((list1.get(0)+1), (list.get(0)+1)));
					}
					break;
				}
			}

		}

		s.close();

	}

	private static int binSearch(int[] arr, int i) {

	//	System.out.println("Search for : "+i);
		int l = 0;
		int r = arr.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (i < arr[mid]) {
				r = mid - 1;
			} else if (i > arr[mid]) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}