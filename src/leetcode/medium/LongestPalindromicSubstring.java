package leetcode.medium;
/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

 */

/*
 * Runtime: 6 ms, faster than 87.82% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Longest Palindromic Substring.

 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abacd"));
	}

	public static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i);
			int len2 = expandFromMiddle(s, i, i + 1);

			int len = Math.max(len1, len2);
			if (len > (end - start)) {
				start = i - ((len - 1) / 2);
				end = i + (len) / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	public static int expandFromMiddle(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left + 1;
	}
}
