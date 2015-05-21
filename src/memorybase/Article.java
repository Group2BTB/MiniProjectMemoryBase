package memorybase;

import java.util.Date;

public class Article {
	/*
	 *@param id is use to store id value of Article
	 *@param title 
	 *@param content
	 *@param author
	 */
	
	private int id;
	private String title;
	private String content;
	private String author;
	private String date;
	
	public Article(){// default constructor
		this.id = 0;
		this.title = " ";
		this.content = " ";
		this.author = " ";
	}
	
	public Article(int id, String title, String content, String author){
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
	public Integer getId() {
		return Integer.valueOf(id);
	}
	
	public void setId(int id) {
		this.id = id ;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

}
