package algorithms.search;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TripleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int lenA;
		int lenB;
		int lenC;

		lenA = s.nextInt();
		lenB = s.nextInt();
		lenC = s.nextInt();

		int arrA[] = new int[lenA];
		int arrB[] = new int[lenB];
		int arrC[] = new int[lenC];

		for (int i = 0; i < lenA; i++) {
			arrA[i] = s.nextInt();
		}
		for (int i = 0; i < lenB; i++) {
			arrB[i] = s.nextInt();
		}
		for (int i = 0; i < lenC; i++) {
			arrC[i] = s.nextInt();
		}
		s.close();
		long ans = triplets(arrA, arrB, arrC);
		System.out.println(ans);
	}

	static int removeDuplicates(int arr[], int n) 
	{ 
	    // Return, if array is empty 
	    // or contains a single element 
	    if (n==0 || n==1) 
	        return n; 
	  
	    int temp[] = new int[n]; 
	  
	    // Start traversing elements 
	    int j = 0; 
	    for (int i=0; i<n-1; i++) 
	  
	        // If current element is not equal 
	        // to next element then store that 
	        // current element 
	        if (arr[i] != arr[i+1]) 
	            temp[j++] = arr[i]; 
	  
	    // Store the last element as whether 
	    // it is unique or repeated, it hasn't 
	    // stored previously 
	    temp[j++] = arr[n-1]; 
	  
	    // Modify original array 
	    for (int i=0; i<j; i++) 
	        arr[i] = temp[i]; 
	  
	    return j; 
	}

	static int binSearch(int arr[], int l, int h, int num) {

		if (num >= arr[h]) {
			return h + 1;
		} else if (num < arr[l]) {
			return l;
		} else if (l <= h) {
			int m = (l + h) / 2;

			if (arr[m] == num || (num > arr[m] && num < arr[m + 1])) {
				return m + 1;
			} else if (num < arr[m] && num > arr[m - 1]) {
				return m;
			} else if (num > arr[m]) {
				return binSearch(arr, m + 1, h, num);
			} else {
				return binSearch(arr, l, m - 1, num);
			}
		} else {
			return 0;
		}
	}

	private static long triplets(int[] A, int[] B, int[] C) {

		Arrays.sort(A);
		removeDuplicates(A, A.length);
		Iterator<Integer> it = Arrays.stream(B).boxed().collect(Collectors.toSet()).iterator();

		// Arrays.sort(B);
		Arrays.sort(C);
		removeDuplicates(C, C.length);
		long result = 0l;

		// System.out.println(binSearch(A, 0, A.length - 1, 1));
		while (it.hasNext()) {
			// System.out.print("B :" + i);
			int num = it.next();
			int x = binSearch(A, 0, A.length - 1, num);
			// System.out.print(" X : " + x);
			int y = binSearch(C, 0, C.length - 1, num);
			// System.out.println(" Y : " + y);
			result += (long) x * (long)y;

		}
		return result;
	}

}
