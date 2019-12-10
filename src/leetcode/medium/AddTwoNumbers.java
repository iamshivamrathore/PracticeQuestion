package leetcode.medium;
/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */

/*
 * RESULT
 * 
 * Runtime: 1 ms, faster than 99.99% of Java online submissions for Add Two Numbers.
	Memory Usage: 44.2 MB, less than 86.83% of Java online submissions for Add Two Numbers.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sumListFirstNode = null;
		int sum = 0;
		int carry = 0;

		ListNode prev = sumListFirstNode;
		while (l1 != null && l2 != null) {
			sum = (l1.val + l2.val + carry);
			carry = sum / 10;
			sum = sum % 10;
			ListNode newNode = new ListNode(sum);
			if (sumListFirstNode == null) {
				sumListFirstNode = newNode;
			} else {
				prev.next = newNode;
			}
			prev = newNode;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			sum = l1.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			prev.next = new ListNode(sum);
			prev = prev.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			sum = l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			prev.next = new ListNode(sum);
			prev = prev.next;
			l2 = l2.next;
		}

		if (carry != 0) {
			prev.next = new ListNode(carry);
		}
		return sumListFirstNode;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}