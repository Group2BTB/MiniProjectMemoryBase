package memorybase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
//import java.util.List;
import java.util.Scanner;

public class Process {
	/*
	 * @param increment to store value of id's increment
	 */
	private static int increment = 0;

	ArrayList<Article> arrList = new ArrayList<Article>();
	Scanner scan = new Scanner(System.in);
	public void addArticle() {
		/*Article art = new Article();
		art.setId(++increment);
		System.out.print("Please input Title:");
		art.setTitle(scan.next());

		System.out.print("Please input Content: ");
		art.setContent(scan.next());

		System.out.print("Please input Author: ");
		art.setAuthor(scan.next());
		
		art.setDate(autoSetDate());

		arrList.add(art);// add object to ArrayList
*/
		for(int i = 0; i <1000000;i++){
			Article art = new Article();
			art.setId(i);
			art.setTitle("Title" +i);
			art.setContent("Content" +i);
			art.setAuthor("Author"+i);
			art.setDate(autoSetDate());
			
			arrList.add(art);
		}
		//scan.nextLine();

	}

	public void searchArticle(ArrayList<Article> arrList, int id) {
		try{
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
		}
		
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
					System.out.println("Input id to search: ");
					String idSearch = scan.nextLine();
					
					if(isInteger(idSearch) == true){
						searchArticle(arrList,Integer.parseInt(idSearch));
						
					}else{
						System.out.println("Your id is not valid! Please try again...");
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

	/*
	 * public int setSearchId(){
	 * System.out.println("Please input Id you want search: "); return
	 * scan.nextInt(); }
	 */

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
