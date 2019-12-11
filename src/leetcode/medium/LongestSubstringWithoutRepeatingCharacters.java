package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		char ch[] = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(ch[i])) {
				max = max > set.size() ? max : set.size();
				set.clear();
				int j = i - 1;
				while (ch[i] != ch[j]) {
					j--;
				}
				i = j + 1;
				set.add(ch[i]);
			} else {
				set.add(ch[i]);
			}
		}
		max = max > set.size() ? max : set.size();
		return max;
	}
}
