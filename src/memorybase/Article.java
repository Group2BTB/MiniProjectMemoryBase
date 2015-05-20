package memorybase;

public class Article {
	
	static int id = 0;
	private String title;
	private String content;
	private String author;
	
	public Article(){
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
	

}
