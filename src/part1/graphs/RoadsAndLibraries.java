package part1.graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Graph1 {

	Map<Integer, List<Integer>> map = new HashMap<>();

	Graph1(int n) {
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
	}

	void addEdge(int source, int dest) {
		map.get(source).add(dest);
		map.get(dest).add(source);
	}

	public long DFS(Set<Integer> visited, int n, int c_lib, int c_road) {
		// TODO Auto-generated method stub
		long result = 0l;
		Iterator<Integer> it = map.keySet().iterator();
		while (visited.size() != map.size()) {

			int source = it.next();
			while (visited.contains(source)) {
				source = it.next();
			}

			// System.out.println("Adding to queue : " + source);
			Queue<Integer> queue = new PriorityQueue<>();
			queue.add(source);
			visited.add(source);
			result += c_lib;
			// System.out.println("Before entering : " + queue);
			while (!queue.isEmpty()) {
				int vertex = queue.poll();
				// System.out.println("Vertex : " + vertex);
				List<Integer> neighbours = map.get(vertex);
				for (int i = 0; i < neighbours.size(); i++) {
					int neighbour = neighbours.get(i);
					if (!visited.contains(neighbour)) {
						// System.out.println("Does not contain ");
						visited.add(neighbour);
						queue.add(neighbour);
						result += c_road;

					}
				}
			}

		}

		return result;

	}
}

public class RoadsAndLibraries {

	// static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
	// long result = 0l;
	// if (c_lib <= c_road) {
	// return (long) c_lib * n;
	// }
	//
	// boolean visited[] = new boolean[n];
	// for (int i = 0; i < cities.length; i++) {
	// int x = cities[i][0] - 1;
	// int y = cities[i][1] - 1;
	//
	// System.out.println("X : " + x + "\t Y:" + y);
	// if (!visited[x] && !visited[y]) {
	// System.out.println("1");
	// visited[x] = true;
	// visited[y] = true;
	// result += (long) c_lib + c_road;
	// } else if (!visited[x]) {
	// System.out.println("2");
	// visited[x] = true;
	// result += c_road;
	// } else if (!visited[y]) {
	// System.out.println("3");
	// visited[y] = true;
	// result += c_road;
	// }
	// }
	// for (int i = 0; i < n; i++) {
	// if (!visited[i]) {
	// System.out.println("4");
	// visited[i] = true;
	// result += c_lib;
	// }
	// }
	//
	// return result;
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();
		for (int qItr = 0; qItr < q; qItr++) {

			int n = scanner.nextInt();

			int m = scanner.nextInt();

			int c_lib = scanner.nextInt();

			int c_road = scanner.nextInt();

			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++) {

				for (int j = 0; j < 2; j++) {
					// sint citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = scanner.nextInt();
				}
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println("Ans : " + result);
		}
		scanner.close();

	}

	private static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		Graph1 g = new Graph1(n);
		if (c_lib <= c_road) {
			return (long) n * c_lib;
		}

		Set<Integer> visited = new HashSet<>();

		for (int i = 0; i < cities.length; i++) {
			g.addEdge(cities[i][0] - 1, cities[i][1] - 1);
		}

		return g.DFS(visited, n, c_lib, c_road);

	}
}
