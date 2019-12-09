package part1.algorithms.random;

import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        
        int pos = 0;
        int neg = 0;
        int zer = 0;
        
        for(int i=0;i<n;i++){
        	arr[i] = s.nextInt();
        	if(arr[i]>0){
        		pos ++;
        	}else if(arr[i] <0){
        		neg ++;
        	}
        	else{
        		zer ++;
        	}
        }
       // System.out.println(pos);
      //  System.out.println(neg);
      //  System.out.println(zer);
        float pos1 = (float)pos/(float)n;
        float neg1 = (float)neg/(float)n;
        float zer1 = (float)zer/(float)n;
       System.out.printf("%.6f\n",pos1);
        System.out.printf("%.6f\n",neg1);
        System.out.printf("%.6f",zer1);
        s.close();
    }
}