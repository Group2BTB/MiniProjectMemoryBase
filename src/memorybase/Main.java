package memorybase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		while(true){
			Article article = new Article();
			
			for(int i = 0; i <1000000; i++){
				
			}
			/*Scanner scan = new Scanner(System.in);
			
			
			System.out.println("Please input Id: ");
			article.setId(scan.nextInt());
			
			System.out.println("Please input Title:");
			article.setTitle(scan.nextLine());
			
			System.out.println("Please input Content: ");
			article.setContent(scan.nextLine());
			
			System.out.println("Please input Author: ");
			article.setAuthor(scan.nextLine());*/
			
			Process pro = new Process(article);
			pro.searchArticle(1);
		} 
	}

}
