package part1.algorithms.random;

import java.util.Scanner;

public class BetweenTwoSets {

      static int getTotalX(int[] a, int[] b) {
        // Complete this function
    	int count = 0;
    	int num = a[0];
    	while(true){
    		boolean flag = true;
    		for(int i=0;i<a.length;i++){
    			if(num%a[i] != 0){
    				flag = false;
    				break;
    			}
    		}
    		if(flag){
    			for(int i=0;i<b.length;i++){
        			if(b[i]% num !=0){
        				flag = false;
        				break;
        			}
        		}
    		}
    		if(flag){
    			count ++;
    		}
    		if(num > b[b.length - 1]){
    			break;
    		}
    		num++;
    	}
    	return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
