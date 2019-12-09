package part1.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[10];
		int aux[] = new int[11];
		int sorted[] = new int[10];
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			arr[i] = rand.nextInt(10);
			aux[arr[i]]++;
		}

		displayArr(arr);
		displayArr(aux);

		int index = 0;
		for (int i = 0; i < aux.length; i++) {
			int temp = aux[i];

			for (int j = 0; j < temp; j++) {

				sorted[index++] = i;

			}
		}

		displayArr(sorted);
		Arrays.sort(arr);
		displayArr(arr);
	}

	static void displayArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
