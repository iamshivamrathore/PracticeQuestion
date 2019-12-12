package leetcode.easy;
/*
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */

/*
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
Memory Usage: 33.7 MB, less than 11.66% of Java online submissions for Reverse Integer.
 */

public class ReverseInteger {
	public int reverse(int x) {
		int rev = 0;
		int prev = 0;
		while (x != 0) {
			int d = x % 10;
			prev = rev;
			rev = rev * 10 + d;
			if ((rev - d) / 10 != prev) {
				return 0;
			}
			x = x / 10;
		}
		return rev;
	}
}
