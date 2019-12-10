/*  
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */



/*
 * Runtime: 4 ms, faster than 43.64% of Java online submissions for Two Sum.
   Memory Usage: 37.2 MB, less than 98.95% of Java online submissions for Two Sum.
 */

package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		LinkedHashMap<Integer, List<Integer>> positionMap = new LinkedHashMap<>();

		int solution[] = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (positionMap.containsKey(nums[i])) {
				positionMap.get(nums[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				positionMap.put(nums[i], list);
			}

		}

		for (int num : nums) {
			if (positionMap.containsKey(target - num)) {

				if (target == num * 2 && positionMap.get(num).size() > 1) {
					solution[0] = positionMap.get(num).get(0);
					solution[1] = positionMap.get(num).get(1);
					break;
				} else if (target != num * 2) {
					solution[0] = positionMap.get(num).get(0);
					solution[1] = positionMap.get(target - num).get(0);
					break;
				}
			}
		}
		return solution;
	}

	public static void main(String[] args) {
		int[] solution = twoSum(new int[] { 3, 3 }, 6);
		System.out.println(solution[0]);
		System.out.println(solution[1]);
	}

}
