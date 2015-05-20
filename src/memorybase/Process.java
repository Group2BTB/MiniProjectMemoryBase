package memorybase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Process {
	
	ArrayList<Article> arrList = new ArrayList<Article>();
	Scanner scan = new Scanner(System.in);
	
	public void addArticle(){
		Article art = new Article();
		art.setId(Article.id += 1);
		System.out.print("Please input Title:");
		art.setTitle(scan.next());
		
		System.out.print("Please input Content: ");
		art.setContent(scan.next());
		
		System.out.print("Please input Author: ");
		art.setAuthor(scan.next());
		
		arrList.add(art);
		
	}
	
	public void searchArticle(ArrayList<Article> arrList, int id){
		int index = Collections.binarySearch(arrList,new Article(id,null, null, null),new Comparator<Article>() {
			@Override
			public int compare(Article art1, Article art2) {
				// TODO Auto-generated method stub
				return art1.getId().compareTo(art2.getId());
			}
		});
		
		System.out.println(arrList.get(index).getTitle());
	}
	
	public void showManu(){
		
		while(true){
			System.out.print("Choose-->: ");
			int option = scan.nextInt();
			if(option == 1){
				addArticle();
			}else if(option == 2){
				System.out.println("Input id to search: ");
				searchArticle(arrList, scan.nextInt());
			}else if(option == 3){
				display();
			}else if(option == 0){
				break;
			}
		}
	}
	
	/*public int setSearchId(){
		System.out.println("Please input Id you want search: ");
		return scan.nextInt();
	}
	
	public int setOption(){
		System.out.println("Choose -->: ");
		return scan.nextInt();
	}*/
	
	public void display(){
		for(Article art : arrList){
			System.out.println(art.getId() +" "+art.getTitle()+" "+art.getContent()+""+art.getAuthor());
		}
	}
}
