/*Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return w4a3d1e1x6.*/

package random_problem_solving;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class Element {
	char ch;
	int count;

	public Element(char ch, int count) {
		this.ch = ch;
		this.count = count;
	}

	public String toString() {
		return ch + " " + count;
	}
}

public class RunLengthEncoding {

	public static void main(String[] args) {
		String inputString = "abccd";
		encode(inputString);

	}

	private static String encode(String inputString) {

		char c = inputString.charAt(0);

		List<Element> list = new ArrayList<>();
		int count = 0;
		Element element = new Element(c, count);
		final int length = inputString.length();
		for (int i = 0; i < length; i++) {
			char charAt = inputString.charAt(i);
			if (charAt == c) {
				element.count++;
			} else {
				list.add(element);
				element = new Element(charAt, 1);
				c = charAt;
			}
		}

		list.add(element);
		System.out.println(list);

		// Queue queue = new LinkedList<>();

		return "";
	}

}
