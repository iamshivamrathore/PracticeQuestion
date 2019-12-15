package leetcode.medium;
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

 */

/*
 * Runtime: 14 ms, faster than 32.59% of Java online submissions for ZigZag Conversion.
Memory Usage: 38.1 MB, less than 91.49% of Java online submissions for ZigZag Conversion.
 */
import java.util.Arrays;

public class ZigZagString {
	public String convert(String s, int numRows) {

		if (numRows == 1) {
			return s;
		}

		String result[] = new String[numRows];
		Arrays.fill(result, "");
		boolean down = true;
		int numRow = 0;

		for (int i = 0; i < s.length(); i++) {
			result[numRow] += s.charAt(i);

			if (numRow == 0) {
				down = true;
			}
			if ((numRow + 1) % numRows == 0) {
				down = false;
			}
			if (down) {
				numRow++;
			} else {
				numRow--;
			}

		}
		String finalString = "";
		for (int i = 0; i < numRows; i++) {
			finalString += result[i];
		}

		return finalString;
	}
}
