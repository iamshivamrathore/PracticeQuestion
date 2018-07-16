package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

	// Complete the encryption function below.
	static String encryption(String s) {
		String ans = "";
		s = s.replaceAll(" ", "");
		int stringLength = s.length();
		double L = Math.sqrt(stringLength);

		int c = (int) Math.ceil(L);
		int r = (int) Math.floor(L);

		while (r * c <= stringLength) {

			r++;
			if (r > c) {
				r--;
				c++;
			}
		}
		System.out.println("Rows : " + r);
		System.out.println("Columns : " + c);
		char[][] result = new char[r][c];

		int counter = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (counter < stringLength)
					result[i][j] = s.charAt(counter++);

				else
					break;
			}
		}

		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if(result[j][i]!=0)
				ans += result[j][i];
			
			}
			
				ans += " ";
		}
	//	 ans = ans.replaceAll("  ", " ");
		return ans.trim();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();

		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String result = encryption(s);
		System.out.println(result);

		scanner.close();
	}
}
