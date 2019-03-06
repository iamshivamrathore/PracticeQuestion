package random_problem_solving;

/*Given a binary number, write a program that prints 1 if given binary number is a multiple of 3.  Else prints 0.
The given number can be big upto 2^100. 
It is recommended to finish the task using one traversal of input binary string.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. 
Each case contains a string containing 0's and 1's.

Output:
For each test case, output a 1 if string is multiple of 3, else 0.

Constraints:
1<=T<=100
1<=Length of Input String<=100

Example:
Input:
2
011
100

Output:
1
0*/

import java.util.Scanner;

public class MultipleOf3 {

	static boolean calculate(String str) {
		int[] count = new int[2]; // 0 - even
		char arr[] = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (arr[i] == '1') {
				count[i % 2]++;
			}
		}

		// System.out.println("Even : "+count[0]);
		// System.out.println("Odd: "+count[1]);
		if (count[0] == count[1] || Math.abs(count[0] - count[1]) % 3 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		// System.out.println("Here");
		for (int i = 0; i < t; i++) {
			String inputString = s.next();
			boolean ans = calculate(inputString);
			if (ans) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
		s.close();
	}
}