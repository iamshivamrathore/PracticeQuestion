package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Graph {
	class Node {
		int vertex;
		long color;

		Node(int vertex, long color) {
			this.vertex = vertex;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + (vertex) + ", color=" + (color) + "]";
		}

	}

	Map<Integer, List<Node>> map;

	Graph(int n) {
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
	}

	void addEdge(int source, int dest, long sColor, long dColor) {
		map.get(dest).add(new Node(source, sColor));
		map.get(source).add(new Node(dest, dColor));

	}

	@Override
	public String toString() {
		return "Graph [map=" + map + "]";
	}

	int calculate(List<Integer> list, int val) {
		int result = Integer.MAX_VALUE;
		System.out.println("List : " + list);
		for (int i = 0; i < list.size(); i++) {
			Set<Integer> visited = new HashSet<>();
			int num = list.get(i);
			System.out.println("\n\nStarting for : " + num);
			visited.add(num);

			int minDist = 0;
			Queue<Integer> queue = new PriorityQueue<>();
			queue.add(num);
			boolean found = false;
			while (!queue.isEmpty()) {
				int node = queue.poll();
				visited.add(node);
				List<Node> neighbours = map.get(node);
				System.out.println("For node : " + node + "    Neighbours: " + neighbours);

				for (int j = 0; j < neighbours.size(); j++) {
					Node neighbour = neighbours.get(j);
					System.out.println("Neighbour : " + neighbour);
					if (!visited.contains(neighbour.vertex)) {
						System.out.println("1");
						visited.add(neighbour.vertex);
						minDist++;
						queue.add(neighbour.vertex);
						if (neighbour.color == val - 1) {
							System.out.println("2");
							found = true;
							// minDist = tempDist;
							break;
						}
					}

				}

				if (found) {
					break;
				}
			}
			System.out.println("Min Dist : " + minDist);
			if (minDist < result) {
				result = minDist;
			}

		}
		return result;
	}
}

public class NearestClone {

	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {

		Graph g = new Graph(graphNodes);
		for (int i = 0; i < graphFrom.length; i++) {
			g.addEdge(graphFrom[i] - 1, graphTo[i] - 1, ids[graphFrom[i] - 1] - 1, ids[graphTo[i] - 1] - 1);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] - 1 == val - 1) {
				list.add(i);
			}
		}
//		System.out.println(g.map);
		if (list.size() <= 1) {
			return -1;
		}
		return g.calculate(list, val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int graphFrom[] = new int[m];
		int graphTo[] = new int[m];
		long ids[] = new long[n];
		for (int i = 0; i < m; i++) {
			graphFrom[i] = s.nextInt();
			graphTo[i] = s.nextInt();
		}
		for (int i = 0; i < n; i++) {
			ids[i] = s.nextLong();
		}
		int val = s.nextInt();
		s.close();
		long result = findShortest(n, graphFrom, graphTo, ids, val);
		System.out.println("Result : " + result);

	}

}
