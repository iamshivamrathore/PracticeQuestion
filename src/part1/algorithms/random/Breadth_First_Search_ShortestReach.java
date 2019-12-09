package part1.algorithms.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Breadth_First_Search_ShortestReach {

	int N;

	class Node {

		int dest;
		int weight;

		Node(int d, int w) {

			dest = d;
			weight = w;
		}

		@Override
		public String toString() {
			return "Node [dest=" + dest + ", weight=" + weight + "]";
		}

	}

	Map<Integer, List<Node>> map;
	int answers[];
	boolean visited[];

	void initialize() {
		map = new HashMap<>();
		answers = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			map.put(i, new ArrayList<>());
			answers[i] = Integer.MAX_VALUE;
		}

	}

	void addEdge(int source, int dest) {
		Node n = new Node(dest, 6);
		map.get(source).add(n);
		n = new Node(source, 6);
		map.get(dest).add(n);

	}

	void calculate() {

		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		int source = -1;
		for (int i = 0; i < q; i++) {
			N = s.nextInt();
			initialize();
			int m = s.nextInt();
			for (int j = 0; j < m; j++) {
				addEdge(s.nextInt() - 1, s.nextInt() - 1);
			}

			source = s.nextInt() - 1;
			// System.out.println("Q : "+q);
			// System.out.println("N : "+N);
			// System.out.println("M : "+m);
			// System.out.println("Source : "+source);
			BFS(source);
			displayAnswers(source);
		}
		s.close();

	}

	private void BFS(int s) {
		// TODO Auto-generated method stub
		// System.out.println(map);
		// System.out.println("In BFS for : "+s);
		answers[s] = 0;
		Iterator<Integer> it = map.keySet().iterator();
		// displayAnswers();
		while (it.hasNext()) {
			int u = getMin();

			if (u == -1) {
				break;
			}
			visited[u] = true;
			// System.out.println("\nReturned min : " + u);

			List<Node> list = map.get(u);
			// System.out.println("Neighbours : "+list);
			for (int i = 0; i < list.size(); i++) {
				if (answers[list.get(i).dest] > answers[u] + list.get(i).weight) {
					answers[list.get(i).dest] = answers[u] + list.get(i).weight;
				}
			}
		}
		// displayAnswers();

	}

	void displayAnswers(int s) {
		// System.out.println("MIN : ");
		for (int i = 0; i < N; i++) {
			if (i != s) {
				if (answers[i] == Integer.MAX_VALUE) {
					answers[i] = -1;
				}
				System.out.print(answers[i] + " ");
			}

		}
		System.out.println();
	}

	private int getMin() {
		// TODO Auto-generated method stub

		int min = Integer.MAX_VALUE;
		int min_index = -1;

		for (int i = 0; i < N; i++) {
			if (answers[i] < min && !visited[i]) {
				min_index = i;
				min = answers[i];
			}
		}
		return min_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Breadth_First_Search_ShortestReach().calculate();
	}

}
