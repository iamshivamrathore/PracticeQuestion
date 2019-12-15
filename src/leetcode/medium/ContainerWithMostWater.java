package leetcode.medium;

/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int size = height.length;
		int area = Math.min(height[0], height[size - 1]) * (size - 1);

		for (int i = 0, j = size - 1; i < j;) {
			int area1 = Math.min(height[i + 1], height[j]) * (j - i - 1);
			int area2 = Math.min(height[i], height[j - 1]) * (j - i - 1);

			int tempArea = Math.max(area1, area2);
			if (area < tempArea) {
				area = tempArea;
				if (area1 > area2) {
					i++;
				} else {
					j--;
				}
			} else {
				if (height[i] > height[j]) {
					j--;
				} else {
					i++;
				}
			}
		}

		return area;
	}
}

/*
 * Runtime: 4 ms, faster than 28.93% of Java online submissions for Container
 * With Most Water. Memory Usage: 40.3 MB, less than 90.38% of Java online
 * submissions for Container With Most Water.
 */