package memorybase;

import java.security.AllPermission;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;

import org.omg.CosNaming.IstringHelper;

public class Process {
	/*
	 * @param increment to store value of id's increment
	 */
	private static int increment = 0;

	ArrayList<Article> arrList = new ArrayList<Article>();
	Scanner scan = new Scanner(System.in);
	public void addArticle() {
		Article art = new Article();
		art.setId(++increment);
		System.out.print("Please input Title:");
		art.setTitle(scan.next());

		System.out.print("Please input Content: ");
		art.setContent(scan.next());

		System.out.print("Please input Author: ");
		art.setAuthor(scan.next());
		
		art.setDate(autoSetDate());

		arrList.add(art);// add artect to ArrayList
		
		/*long s = System.currentTimeMillis();
		for(int i = 0; i <1000000;i++){
			
			Article art = new Article();
			art.setId(i);
			art.setTitle("Title" +i);
			art.setContent("Content" +i);
			art.setAuthor("Author"+i);
			art.setDate(autoSetDate());
			
			arrList.add(art);
			
		}
		long st = System.currentTimeMillis();
		System.out.println((st-s)/1000.0);*/
		scan.nextLine();

	}

	public void searchArticle(ArrayList<Article> arrList,String str) {
		
		Iterator<Article> itr = arrList.iterator();
		while(itr.hasNext()){
			Article art = itr.next(); 
			String str1 = art.getTitle()+" "+art.getAuthor()+" "+art.getContent();
			if(str1.toUpperCase().matches(".*"+str.toUpperCase()+".*")){
				
				System.out.println(art.getId()+" "+art.getTitle()+" "+art.getAuthor()+" "+art.getContent());
				
			}else{
				
				System.out.println("Sorry invalid keyword!");
				break;
			}
				
		}
		
		/*try{
			int index = Collections.binarySearch(arrList, new Article(id, null,
					null, null), new Comparator<Article>() {
				@Override
				public int compare(Article art1, Article art2) {
					// TODO Auto-generated method stub
					return art1.getId().compareTo(art2.getId());
				}
			});
			System.out.println(arrList.get(index).getTitle());
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("Doesn't have this id in List!");
		}*/
		
	}

	public void showManu() {

		while (true) {
			System.out.print("--> Choose: ");
			String option = scan.nextLine();

			if (isInteger(option) == true) {
				int choice = Integer.parseInt(option);
				if (choice == 1) {
					addArticle();

				} else if (choice == 2) {
					
					System.out.print("Search: ");
					String keyword = scan.next();
					if(keyword == null){
						System.out.println("Please input keyword!");
					}else{
						searchArticle(arrList, keyword);
						scan.nextLine();
					}
					
				} else if (choice == 3) {
					display();
					
				} else if (choice == 0) {

					System.out.println("Thank you using our program!");
					System.exit(0);
				}
			} else {
				System.out.println("Input invalid id!");
			}

		}
	}

	public void display() {
		for (Article art : arrList) {
			System.out.println(art.getId() + " " + art.getTitle() + " "
					+ art.getContent() + "" + art.getAuthor()+" "+art.getDate());
		}
	}

	public boolean isInteger(String option) {
		try {
			Integer.parseInt(option);
			return true;

		} catch (NumberFormatException nfe) {

			return false;
		}
	}
	
	public String autoSetDate(){
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(today);
	}
}
