package part1.algorithms.random;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TimeConversion {

    static String timeConversion(String s) {
        // Complete this function
        String result = "";
        try{
         SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
		 
		 SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		 
	        
	     result = sdf1.format(sdf.parse(s));
        }catch(Exception e){}
        
	        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
