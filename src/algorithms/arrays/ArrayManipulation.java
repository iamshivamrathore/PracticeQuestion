package algorithms.arrays;

import java.util.Scanner;

public class ArrayManipulation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        long max = Integer.MIN_VALUE;
		int m = s.nextInt();
		int arr[] = new int[n+1];
		/*PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				return i2-i1;
			}
		}); */
		for(int i=0;i<m;i++){
			int x = s.nextInt();
			int y = s.nextInt();
			int val = s.nextInt();
				
            arr[x] += val;
            if(y+1<=n){
                arr[y+1] += -val;
            }
			//System.out.println(); */
		}
        long sum =0 ;
        for(long temp : arr){
			sum += temp;
            if(sum > max){
                max = sum;
            }
			}
		s.close();
		System.out.println(max);
    }

    
}