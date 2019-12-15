package leetcode.easy;
/*
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */

/*
 * Runtime: 7 ms, faster than 74.51% of Java online submissions for Palindrome Number.
Memory Usage: 35.8 MB, less than 5.02% of Java online submissions for Palindrome Number.

 */
public class Palindrome {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int rev = 0;
		int num = x;
		while (x > 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		if (rev == num) {
			return true;
		}
		return false;
	}
}
