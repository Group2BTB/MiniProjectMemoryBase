package memorybase;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		ArrayList <Article> arrList = new ArrayList<Article>();
		
		arrList.add(new Article(1, "globle warming", "globle warming provide many", "dara"));
		arrList.add(new Article(2, "globle warming", "globle warming provide many disadvantages", "veasna"));
		arrList.add(new Article(3, "globle warming", "globle warming provide many disadvantages", "vicheka"));
		arrList.add(new Article(4, "globle warming", "globle warming provide many disadvantages", "sreyroth"));
		arrList.add(new Article(5, "globle warming", "globle warming provide many disadvantages", "chanthorn"));
		arrList.add(new Article(6, "globle warming", "globle warming provide many disadvantages", "narith"));
		
		for(Article art: arrList){
			
			int a = 5;
			
			if(art.getAuthor() == "narith"){
				System.out.println(art.getAuthor());
			}
//			System.out.println(art.getAuthor());
		}
		
		
	} 

}
