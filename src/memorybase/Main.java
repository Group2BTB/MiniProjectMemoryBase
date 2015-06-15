package memorybase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Scanner scan = new Scanner(System.in);
			
		Process pro = new Process();
					
			for(int i=0; i<1000000; i++){
				
				pro.arrList.add(new Article(i,"title"+i, "content"+i,"author"+i, "date"+i));
			}
			
		long start = System.currentTimeMillis();
			
			pro.showManu(); 
			
		long stop = System.currentTimeMillis();
		System.out.println((stop - start)/60000.0+"min");
			
				
	}

}
