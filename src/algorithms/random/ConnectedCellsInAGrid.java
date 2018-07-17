package algorithms.random;

import java.util.Scanner;

public class ConnectedCellsInAGrid {

    static int m;
	static int n;
	static int arr[][];

	static int ff(int x, int y) {
	//	System.out.print("Inside ff For : ("+x+","+y+")");
	//	System.out.println("\t M,N : "+m+"  "+n);
		if (x >= n || y >= m || x < 0 || y < 0 || arr[x][y] == -1
				|| arr[x][y] == 0) {
	//		System.out.println(" 0 ");
			return 0;
		}
		arr[x][y] = -1;
		
		return 1 + ff(x - 1, y - 1) + ff(x - 1, y) + ff(x - 1, y + 1)
				+ ff(x, y + 1) + ff(x + 1, y + 1) + ff(x + 1, y)
				+ ff(x + 1, y - 1) + ff(x, y - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		 m = s.nextInt();
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		s.close();

		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
		//			System.out.println("For : ("+i+","+j+")");
					count = Math.max(count, ff(i, j));
				}
			}
		}

		System.out.println(count);
	}

}
