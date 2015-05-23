package memorybase;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;

/*
 * Class Process use to store all methods 
 */

public class Process {
	/*
	 * @param increment is used to store value of id's increment
	 * @param arrList is used to store all data from Article object
	 * @param indexSeach is use to store all index that get from searchArticle Method
	 * method addArticle() use to add Article object to arrList of ArrayList<Article>
	 */
	private static int increment = 0;

	ArrayList<Article> arrList = new ArrayList<Article>();

	ArrayList<Article> indexSearch = new ArrayList<Article>();

	public void addArticle() {
		Article art = new Article();
		Scanner scan = new Scanner(System.in);
		art.setId(++increment);
		System.out.print("Enter Title:");
		art.setTitle(scan.next());

		System.out.print("Enter Content: ");
		art.setContent(getMiltiLineString());// set content to object Article by calling method getMiltiLineString();

		System.out.print("Enter Author: ");
		art.setAuthor(scan.next());

		art.setDate(autoSetDate());// set Date by calling method autoSetDate();

		System.out.print("What do you want to save: 1.Save&Menu 2.Save&New 3.No\t:");
		int opt = scan.nextInt();
		if (opt == 1) {
			arrList.add(art);// add object art of Article to ArrayList
			System.out.println("Article saved...");
		} else if (opt == 2) {
			arrList.add(art);// add object art of Article to ArrayList
			System.out.println("Article saved...");
			addArticle();// Call function addArticle again
		} else if (opt == 3) {
			System.out.println("Record cancel!");
			return;
		}

		/*
		 * long s = System.currentTimeMillis(); for(int i = 0; i <1000;i++){
		 * 
		 * Article art = new Article(); art.setId(i); art.setTitle("Title" +i);
		 * art.setContent("Content" +i); art.setAuthor("Author"+i);
		 * art.setDate(autoSetDate());
		 * 
		 * arrList.add(art);
		 * 
		 * } long st = System.currentTimeMillis();
		 * System.out.println((st-s)/1000.0);
		 */

	}
	public void deleteArticle(/**/ArrayList<Article> arrList, int id){
		int index = Collections.binarySearch(arrList,new Article(id, null, null,null, null), new Comparator<Article>() {

			@Override
			//compare index and id 
			public int compare(Article art1, Article art2) {
				return art1.getId().compareTo(art2.getId());
			}
		} );
		
			if(arrList.get(index).getId() == id){
					arrList.remove(id-1);
			}else{	
				System.out.println("Your Keyword is invalid!");
			}		
		}        
	
	/*
	 * @param art of Object Article to store " itr.next()".
	 * @param itrIndex use to store index when condition "{str1.toUpperCase().matches(".*"+str.toUpperCase()+".*"}" is true
	 * @param opt is used to check option 1.Search 2.New Search 3.Cancel
	 */
	public void searchArticle(ArrayList<Article> arrList, String str) {
		
		Iterator<Article> itr = arrList.iterator();
		Scanner scan = new Scanner(System.in);
		String str1 = "";
		int itrIndex = 0;
		System.out.print("Choose option: 1.Search 2.New Search 3.Cancel :");
		String opt = scan.nextLine();
		if(isInteger(opt) == true){
			
			int choice = Integer.parseInt(opt);
			if (choice == 1) {
				while (itr.hasNext()) {
					Article art = itr.next();
					str1 = art.getTitle() + " " + art.getAuthor() + " "+ art.getContent();// Variable str1 use to concate title, author, content together
					if (str1.toUpperCase().matches(".*" + str.toUpperCase() + ".*")) {
						indexSearch.add(art);// add index of object Article to indexSearch ArrayList.
						System.out.println(art.getId() + " " + art.getTitle() + " "+ art.getAuthor() + " " + art.getContent());
					}
				}
			} else if (choice == 2) {
				while (itr.hasNext()) {
					Article art = itr.next();
					str1 = art.getTitle() + " " + art.getAuthor() + " "	+ art.getContent();
					if (str1.toUpperCase().matches(".*" + str.toUpperCase() + ".*")) {
						indexSearch.add(art);
						System.out.println(art.getId() + " " + art.getTitle() + " "+ art.getAuthor() + " " + art.getContent());
					}

				}
			} else if (choice == 3) {
				System.out.println("Search cancel!");
				return;
			}
		}

		if (str1.toUpperCase().matches(".*" + str.toUpperCase() + ".*") == false) {
			System.out.println("Sorry invalid keyword!");
		}

		/*
		 * try{ int index = Collections.binarySearch(arrList, new Article(id,
		 * null, null, null), new Comparator<Article>() {
		 * 
		 * @Override public int compare(Article art1, Article art2) { // TODO
		 * Auto-generated method stub return
		 * art1.getId().compareTo(art2.getId()); } });
		 * System.out.println(arrList.get(index).getTitle());
		 * 
		 * }catch(IndexOutOfBoundsException e){
		 * System.out.println("Doesn't have this id in List!"); }
		 */

	}

	
	public void display() {
		for (Article art : arrList) {
			System.out.println(art.getId() + " " + art.getTitle() + " "
					+ art.getContent() + "" + art.getAuthor() + " "
					+ art.getDate());
		}
	}
	/*
	 * IsInteger() is used to validate that the parameter option is Integer or not
	 */
	public boolean isInteger(String option) {
		try {
			Integer.parseInt(option);
			return true;

		} catch (NumberFormatException nfe) {

			return false;
		}
	}

	public String autoSetDate() {
		Date today = Calendar.getInstance().getTime();// Use to get time from system.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");// Use to change date format.
		return sdf.format(today);
	}
	
	public String getMiltiLineString(/*String msg*/){
		Scanner scan = new Scanner(System.in);
		StringBuffer sb=new StringBuffer();
	    System.out.println(/*msg*/" (Press Enter the content + '.' + Enter to Finish) "+" => ");
		while (true) {
			String imsi=scan.nextLine();
			if(imsi!=null && imsi.trim().length()==1 && imsi.trim().charAt(0)=='.') break;
			if(imsi==null) imsi="";
			sb.append(imsi);
		}
		return sb.toString();
	}
	public void showManu() {
		Scanner scan = new Scanner(System.in);// Create object scan to take Data
												// form keyboard
		while (true) {
			System.out.print("--> Choose: ");
			String option = scan.nextLine();

			if (isInteger(option) == true) {
				int choice = Integer.parseInt(option);
				if (choice == 1) {
					addArticle();

				} else if (choice == 2) {

					System.out.print("Search: ");
					String keyWord = scan.nextLine();
					searchArticle(arrList, keyWord);

				} else if (choice == 3) {
					System.out.print("Please input id to delete: ");
					String keyWord = scan.nextLine();
					if(isInteger(keyWord) == true){
						deleteArticle(arrList, Integer.parseInt(keyWord));
					}else{
						System.out.println("");
					}
				}else if (choice == 4){
					display(); 
				}else if (choice == 0) {

					System.out.println("Thank you using our program!");
					System.exit(0);
				}
			} else {
				System.out.println("Input invalid id!");
			}
		}
	}

}
