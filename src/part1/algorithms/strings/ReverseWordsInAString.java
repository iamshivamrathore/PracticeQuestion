package part1.algorithms.strings;

public class ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "This is the day of reckoning";

		String reverseString = reverse(string);
		System.out.println(reverseString);
	}

	private static String reverse(String string) {
		char arr[] = string.toCharArray();
		String reversedString = "";
		final int length = string.length();
		for (int i = 0; i < length; i++) {
			StringBuilder inputString = new StringBuilder();
			while (i < length && arr[i] != ' ') {
				inputString.append(arr[i++]);
				// System.out.println("Here: "+arr[i]);
			}

			// (i==length) ? reversedString += reverseWord(inputString.toString())+"";
			reversedString += (i == length) ? reverseWord(inputString.toString())
					: reverseWord(inputString.toString()) + " ";
		}
		return reversedString;
	}

	private static String reverseWord(String word) {

		char arr[] = word.toCharArray();
		final int length = word.length();
		for (int i = 0; i < length / 2; i++) {
			char temp = arr[i];
			arr[i] = arr[length - i - 1];
			arr[length - i - 1] = temp;
		}

		return new String(arr);
	}

}
