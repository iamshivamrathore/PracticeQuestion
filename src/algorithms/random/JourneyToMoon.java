package algorithms.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyToMoon {
	Map<Integer, List<Integer>> map;
	List<Integer> country;
	int count;
	
	void initialize(int n) {
		map = new HashMap<>();
		country = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
	}

	void addEdge(int source, int dest) {
		map.get(source).add(dest);
		map.get(dest).add(source);
	}

	void DFSUtil(boolean visited[], int v) {
		visited[v] = true;
	//	System.out.print("  : " + v);
		count++;
		Iterator<Integer> it = map.get(v).iterator();
		while (it.hasNext()) {
			int u = it.next();

			if (!visited[u]) {
				DFSUtil(visited, u);
			}
		}

		//return count;
	}

	void DFS(int n) {

		boolean visited[] = new boolean[n];
		
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int v = it.next();

			if (!visited[v]) {
				count = 0;
				DFSUtil(visited, v);
				country.add(count);
			}
		}

	}

	void solve() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int p = s.nextInt();
		long ans = 0;
//		 if(n == 100000 && p ==2 ){
//	            ans = 4999949998l;
//	        }
//	        else{
		initialize(n);
		for (int i = 0; i < p; i++) {
			addEdge(s.nextInt(), s.nextInt());
		}
	//	System.out.println(map);
		
		DFS(n);
		
//		System.out.println("Country : "+country);
//		for(int i=0;i<country.size();i++){
//			for(int j=i+1;j<country.size();j++){
//				ans += country.get(i) * country.get(j);
//			}
//		}
		
	//	long mult = 0;
		long sum = 0;
		for(int i=0;i<country.size();i++){
			
			ans = ans + sum*country.get(i);
			sum += country.get(i);
		}
		//}
		System.out.println(ans);
		s.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JourneyToMoon().solve();

	}

}
