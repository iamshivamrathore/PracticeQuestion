package algorithms.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Kruskal_MST {

	int N;
	int M;
	int parent[];
	boolean in[];
	boolean out[];
	boolean visited[];

	class Edge {
		int source;
		int dest;
		int weight;

		public Edge(int source, int dest, int weight) {
			// super();
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + source + "," + dest + ")[" + weight + "]  ";
		}

	}

	List<Edge> edges;

	void addEdge(int source, int dest, int weight) {
		Edge e = new Edge(source - 1, dest - 1, weight);
		edges.add(e);
		e = new Edge(dest - 1, source - 1, weight);
		edges.add(e);

	}

	void initialize() {
		edges = new ArrayList<>();
		parent = new int[N];
		in = new boolean[N];
		out = new boolean[N];

		for (int i = 0; i < N; i++) {
			parent[i] = -1;
		}

	}

	boolean findCycle() {

		for (int i = 0; i < edges.size(); i += 2) {
			Edge e = edges.get(i);

			int n1 = e.source;
			int n2 = e.dest;

			if (find(n1) == find(n2)) {
				return true;
			} else {
				Union(n1, n2);
			}

			System.out.println(Arrays.toString(parent));
		}
		return false;
	}

	int find(int i) {
		if (parent[i] == -1) {
			return i;
		} else {
			return find(parent[i]);
		}
	}

	void Union(int x, int y) {
		int x1 = find(x);
		int y1 = find(y);

		parent[x1] = y1;
	}

	void sortEdges() {
		edges.sort((Edge e1, Edge e2) -> {
			if (e1.weight < e2.weight) {
				return -1;
			} else if (e1.weight > e2.weight) {
				return 1;
			} else {
				if (e1.dest + e1.source > e2.dest + e2.source) {
					return 1;
				} else {
					return -1;
				}
			}

		});
	}

	void calculate() {

		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();

		initialize();

		for (int i = 0; i < M; i++) {
			addEdge(s.nextInt(), s.nextInt(), s.nextInt());
		}

		s.close();

		// System.out.println(edges);
		sortEdges();

		Iterator<Edge> it = edges.iterator();
		int edgeCount = 0;
		int weight = 0;
		while (edgeCount < M && it.hasNext()) {
			Edge e = it.next();
			int node1 = e.dest;
			int node2 = e.source;

			if (find(node1) != find(node2)) {
				weight += e.weight;
				edgeCount++;
				Union(node1, node2);
			}
		}

		// System.out.println(edges);
		System.out.println(weight);

		// System.out.println(findCycle());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kruskal_MST().calculate();

	}

}
