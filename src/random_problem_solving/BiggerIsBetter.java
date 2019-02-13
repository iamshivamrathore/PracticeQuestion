/*Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.

Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:

It must be greater than the original word
It must be the smallest word that meets the first condition
For example, given the word , the next largest word is .

Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.

Function Description

Complete the biggerIsGreater function in the editor below. It should return the smallest lexicographically higher string possible from the given string or no answer.

biggerIsGreater has the following parameter(s):

w: a string
*/

package random_problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsBetter {

	static String biggerIsGreater(String w) {
		String result = "";
		char arr[] = w.toCharArray();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println(biggerIsGreater(s.next()));
		}
		s.close();
	}

}
