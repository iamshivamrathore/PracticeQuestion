/*Assembly Line Scheduling | DP-34
A car factory has two assembly lines, each with n stations. A station is denoted by Si,j where i is either 1 or 2 and indicates the assembly line the station is on, and j indicates the number of the station. The time taken per station is denoted by ai,j. Each station is dedicated to some sort of work like engine fitting, body fitting, painting and so on. So, a car chassis must pass through each of the n stations in order before exiting the factory. The parallel stations of the two assembly lines perform the same task. After it passes through station Si,j, it will continue to station Si,j+1 unless it decides to transfer to the other line. Continuing on the same line incurs no extra cost, but transferring from line i at station j � 1 to station j on the other line takes time ti,j. 
Each assembly line takes an entry time ei and exit time xi which may be different for the two lines. 
Give an algorithm for computing the minimum time it will take to build a car chassis.*/

package part1.dynamicProgramming.geeks;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AssemblyLineScheduling {

	static int calculate(int i, int j, int e1, int e2, Map<String, Integer> map, int a[][], int t[][]) {

		System.out.println("I, J : " + i + " " + j);
		if (map.containsKey(i + ":" + j)) {
			return map.get(i + ":" + j);
		}

		if (j == 0) {

			if (i == 0) {
				map.put(i + ":" + j, a[i][j] + e1);
			} else if (i == 1) {
				map.put(i + ":" + j, a[i][j] + e2);
			}

		} else {
			if (i == 0) {
				int min = Math.min(calculate(0, j - 1, e1, e2, map, a, t) + a[i][j],
						calculate(1, j - 1, e1, e2, map, a, t) + t[1][j] + a[i][j]);
				map.put(i + ":" + j, min);
			} else {
				int min = Math.min(calculate(1, j - 1, e1, e2, map, a, t) + a[i][j],
						calculate(0, j - 1, e1, e2, map, a, t) + t[0][j] + a[i][j]);
				map.put(i + ":" + j, min);
			}
		}
		return map.get(i + ":" + j);

	}

	public static void main(String[] args) throws IOException {
		int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
		int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
		int e1 = 10;
		int e2 = 12;
		int x1 = 18;
		int x2 = 7;
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(Math.min(calculate(1, 3, e1, e2, map, a, t) + x2, calculate(0, 3, e1, e2, map, a, t) + x1));
		System.out.println(map);
	}
}