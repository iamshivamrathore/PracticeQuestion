package part1.algorithms.strings;

public class StringToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = "123s4";
		try {
			System.out.println("Num : " + convert(inputString));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static int convert(String str) throws Exception {
		char arr[] = str.toCharArray();
		int num = 0;
		for (int i = 0; i < arr.length; i++) {

			char c = arr[i];
			if (c >= 48 && c <= 57) {
				int digit = c - '0';
				num = num * 10 + digit;
			} else {

				throw new Exception("Not a number");
			}
		}

		return num;
	}

}
