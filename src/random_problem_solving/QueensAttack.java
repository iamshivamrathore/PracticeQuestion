package random_problem_solving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack {

	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

		r_q--;
		c_q--;
		 
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < obstacles.length; i++) {
			int x = obstacles[i][0] - 1;
			int y = obstacles[i][1] - 1;

			if (map.containsKey(x)) {
				map.get(x).add(y);
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(y);
				map.put(x, set);
			}
		}

		// System.out.println("Map : " + map);

		int bottomLeft = calcBottomLeft(n, r_q, c_q, map);
		// System.out.println("Bottom Left : " + bottomLeft);

		int bottomRight = calcBottomRight(n, r_q, c_q, map);
		// System.out.println("Bottom Right: " + bottomRight);

		int topLeft = calcTopLeft(n, r_q, c_q, map);
		// System.out.println("Top Left : " + topLeft);

		int topRight = calcTopRight(n, r_q, c_q, map);
		// System.out.println("Top Right: " + topRight);

		int top = calcTop(n, r_q, c_q, map);
		// System.out.println("Top : " + top);

		int bottom = calcBottom(n, r_q, c_q, map);
		// System.out.println("Bottom : " + bottom);

		int left = calcLeft(n, r_q, c_q, map);
		// System.out.println("Left : " + left);

		int right = calcRight(n, r_q, c_q, map);
		// System.out.println("Right : " + right);

		return bottomLeft + bottomRight + topLeft + topRight + top + bottom + left + right;
	}

	static int calcBottomLeft(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q - 1, j = c_q - 1; i >= 0 && j >= 0; i--, j--) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcBottomRight(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q - 1, j = c_q + 1; i >= 0 && j < n; i--, j++) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcTopRight(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q + 1, j = c_q + 1; i < n && j < n; i++, j++) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcTopLeft(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q + 1, j = c_q - 1; i < n && j >= 0; i++, j--) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcLeft(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q, j = c_q - 1; j >= 0; j--) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcRight(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q, j = c_q + 1; j < n; j++) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcTop(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q + 1, j = c_q; i < n; i++) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	static int calcBottom(int n, int r_q, int c_q, Map<Integer, Set<Integer>> map) {
		int result = 0;
		for (int i = r_q - 1, j = c_q; i >= 0; i--) {
			if (map.containsKey(i) && map.get(i).contains(j)) {
				return result;
			} else {
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int r_q = s.nextInt();
		int c_q = s.nextInt();
		int obstacles[][] = new int[k][2];
		for (int i = 0; i < k; i++) {
			obstacles[i][0] = s.nextInt();
			obstacles[i][1] = s.nextInt();
		}
		s.close();

		int result = queensAttack(n, k, r_q, c_q, obstacles);
		System.out.println("Result : " + result);
	}

}
