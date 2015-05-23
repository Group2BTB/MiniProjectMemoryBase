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

/*
 * Class Process use to store all methods 
 */

public class Process {
	/*
	 * @param increment is used to store value of id's increment
	 * 
	 * @param arrList is used to store all data from Article object
	 * 
	 * @param indexSeach is use to store all index that get from searchArticle
	 * Method method addArticle() use to add Article object to arrList of
	 * ArrayList<Article>
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
		art.setContent(getMiltiLineString());// set content to object Article by
												// calling method
												// getMiltiLineString();

		System.out.print("Enter Author: ");
		art.setAuthor(scan.next());

		art.setDate(autoSetDate());// set Date by calling method
		autoSetDate();

		System.out
				.print("What do you want to save: 1.Save and Menu 2.Save and New 3.Cancel\t:");
		String option = scan.next();

		if (isInteger(option) == true) {
			int choice = Integer.parseInt(option);
			if (choice == 1) {
				arrList.add(art);// add object art of Article to ArrayList
				System.out.println("Article saved...");

			} else if (choice == 2) {
				arrList.add(art);// add object art of Article to ArrayList
				System.out.println("Article saved...");
				addArticle();// Call function addArticle again

			} else if (choice == 3) {
				System.out.println("Record cancel!");
				return;
			} else if (choice < 1 || choice > 3) {
				System.out.println("Invalid keyword! Please try again! ");
				addArticle();
			}

		} else {
			System.out.println("Invalid keyword!");
		}

		/*
		 * long s = System.currentTimeMillis(); for (int i = 0; i < 1000000;
		 * i++) {
		 * 
		 * Article art = new Article(); art.setId(i); art.setTitle("Title" + i);
		 * art.setContent("Content" + i); art.setAuthor("Author" + i);
		 * art.setDate(autoSetDate());
		 * 
		 * arrList.add(art);
		 * 
		 * } long st = System.currentTimeMillis(); System.out.println((st - s) /
		 * 1000.0);
		 */

	}

	public void deleteArticle(/**/ArrayList<Article> arrList, int id) {
		int index = Collections.binarySearch(arrList, new Article(id, null,
				null, null, null), new Comparator<Article>() {

			@Override
			// compare index and id
			public int compare(Article art1, Article art2) {
				return art1.getId().compareTo(art2.getId());
			}
		});
		Scanner scan = new Scanner(System.in);
		System.out.println(arrList.get(index).getId() + " "
				+ arrList.get(index).getTitle() + " "
				+ arrList.get(index).getContent() + " " 
				+ arrList.get(index).getAuthor()+" "
				+ arrList.get(index).getDate());
		System.out.print("Are you sure to delete this Article? (y/n): ");
		String option = scan.nextLine();
		if (option.matches("y")) {
			if (arrList.get(index).getId() == id) {
				arrList.remove(id - 1);
				System.out.println("Delete successfully!");
			}
		} else if (option.matches("n")) {
			System.out.println("Delete was canceled!");
		}
	}

	/*
	 * @param art of Object Article to store " itr.next()".
	 * 
	 * @param itrIndex use to store index when condition
	 * "{str1.toUpperCase().matches(".*"+str.toUpperCase()+".*"}" is true
	 * 
	 * @param opt is used to check option 1.Search 2.New Search 3.Cancel
	 */
	public void searchArticle(ArrayList<Article> arrList, String str) {

		Iterator<Article> itr = arrList.iterator();
		Scanner scan = new Scanner(System.in);
		String str1 = "";
		int itrIndex = 0;
		// long s = System.currentTimeMillis();
		while (itr.hasNext()) {
			Article art = itr.next();
			str1 = art.getTitle() + " " + art.getAuthor() + " "
					+ art.getContent();// Variable str1 use to concate title,
										// author, content together
			if (str1.toUpperCase().matches(".*" + str.toUpperCase() + ".*")) {
				indexSearch.add(art);// add index of object Article to
										// indexSearch ArrayList.
				System.out.println(art.getId() + " " + art.getTitle() + " "
						+ art.getAuthor() + " " + art.getContent());
			}
		}
		if (str1.toUpperCase().matches(".*" + str.toUpperCase() + ".*") == false) {
			System.out.println("Sorry invalid keyword!");
		}
		/*
		 * long st = System.currentTimeMillis();
		 * 
		 * System.out.println((st-s)/1000.00);
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
	 * IsInteger() is used to validate that the parameter option is Integer or
	 * not.
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
		Date today = Calendar.getInstance().getTime();// Use to get time from
														// system.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");// Use to
																	// change
																	// date
																	// format.
		return sdf.format(today);
	}

	public String getMiltiLineString(/* String msg */) {
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		System.out
				.println(/* msg */" (Press Enter the content + '.' + Enter to Finish) "
						+ " => ");
		while (true) {
			String imsi = scan.nextLine();
			if (imsi != null && imsi.trim().length() == 1
					&& imsi.trim().charAt(0) == '.')
				break;
			if (imsi == null)
				imsi = "";
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
					if (isInteger(keyWord) == true) {
						deleteArticle(arrList, Integer.parseInt(keyWord));
					} else {
						System.out.println("");
					}
				} else if (choice == 4) {
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

}
