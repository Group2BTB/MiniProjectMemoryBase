package memorybase;

import java.util.ArrayList;

public class Process {
	
	ArrayList <Article> arrList = new ArrayList<Article>();
	
	public Process(Article art){
		this.arrList.add(art);// add object art to 
	}
	
	public void addArticle(Article art){
		
		arrList.add(art);
		
	}
	
	public void searchArticle(int id){
		for(Article art : this.arrList){
			if(art.getId() == id){
				System.out.println(art.getId()+""+art.getTitle() + " " +art.getAuthor() +" "+art.getContent());
			}else{
				System.out.println("Id is invalid!");
			}
		}
	}
	
	public void showManu(int option){
		
	}
	
}
