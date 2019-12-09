package part1.algorithms.arrays;

public class SearchInSorted {

	public static void main(String[] args) {

		int arr[] = new int[] { 100, 20, 25, 30, 35, 40, 50 };
		int arr2[] = new int[] { 30, 35, 40, 50, 100, 20, 25 };

		int left = 0;
		int right = arr.length - 1;
		int num = 20;
		System.out.println("1 : " + binSearch(arr, left, right, num));
		System.out.println("2 : "+binSearch(arr2, left, right, num));

	}

	static int binSearch(int arr[], int left, int right, int num) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;

		if (num == arr[mid]) {
			return mid;
		}
		

//		System.out.println("Left : " + arr[left]);
//		System.out.println("Right : " + arr[right]);
//		System.out.println("Mid : " + arr[mid]);

		if (arr[left] < arr[mid]) {
			if (num > arr[left] && num < arr[mid]) {
				return binSearch(arr, left, mid - 1, num);
			} else {
				return binSearch(arr, mid + 1, right, num);
			}
		} else {
			if (num > arr[mid] && num < arr[right]) {
				return binSearch(arr, mid + 1, right, num);
			} else {
				return binSearch(arr, left, mid - 1, num);
			}
		}

	}

}
