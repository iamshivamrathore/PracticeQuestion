package random_problem_solving;

import java.util.Scanner;

public class TimeInWords {

	static String[] hour = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve" };
	static String[] tensMultiple = { "", "", "twenty", "thirty" };
	static String[] twoDigits = { "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
			"eighteen", "nineteen" };

	static String timeInWords(int h, int m) {
		String part1 = "";
		String part2 = "";

		if (m == 0) {
			part2 = " o' clock";
			part1 = hour[h];
		} else if (m <= 30) {
			part1 = hour[h];
			if (m <= 19 && m >= 10) {
				part2 = " " + twoDigits[m % 10];
			} else {
				part2 = tensMultiple[m / 10] + " " + hour[m % 10];
			}
		}else {
			part1 = hour[h+1];
		}
		return part1 + part2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		int m = s.nextInt();
		s.close();
		System.out.println("Result : " + timeInWords(h, m));
	}

}
