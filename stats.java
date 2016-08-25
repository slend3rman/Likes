
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Scanner;

public class Stats {

	/* Main Function */
	public static void main(String[] args) throws IOException {

		int choice;
		do {
			System.out.println("\n1.Facebook \n2.StumbleUpon\n3.LinkedIn\n4.Reddit" + "\n5.Pinterest\n6.Exit");
			Scanner In = new Scanner(System.in);
			choice = In.nextInt();
			if (choice != 6)
				Site(choice);
		} while (choice != 6);
		System.out.println("~ ~ ~ EXIT ~ ~ ~");

	}

	/*
	 * This is used to decide which site to fetch stats from
	 */
	static void Site(int choice) throws IOException {

		String PageDoc = input();
		decideSite(PageDoc, choice);
	}

	/*
	 * This function takes URL of a page as input and returns it
	 */
	static String input() throws IOException {

		Scanner b = new Scanner(System.in);
		System.out.println("URL of page");
		String PageURL = b.nextLine();
		return PageURL;
	}

	/*
	 * This function takes the whole Document of the endpoint link as an input
	 * with data type String and calls the getSource and print functions
	 */
	static void decideSite(String Doc, int ForS) throws IOException {
		String url = ",";
		String PageDoc;
		char end = ','; // terminating characters are different for different
						// sites
		if (ForS == 1) {
			System.out.println("link discontinued");
			return;
			/*url = ("https://api.facebook.com/method/links.getStats?urls=%%" + Doc + "%%&format=json");
			System.out.println("Number of Likes : ");*/
		}
		if (ForS == 2) {
			url = ("http://www.stumbleupon.com/services/1.01/badge.getinfo?url=" + Doc);
			System.out.println("Number of Views : ");
		}
		int coloncount = 6;
		if (ForS == 3) {
			url = ("https://www.linkedin.com/countserv/count/share?format=json&url=" + Doc);
			System.out.println("Number of shares :");
			coloncount = 1;
		}
		if (ForS == 4) {
			url = ("https://buttons.reddit.com/button_info.json?url=" + Doc);
			try {
				PageDoc = getSource(url);
				System.out.println("Number of ups :");
				print(PageDoc, 26, end);
				System.out.println("\nNumber of downs :");
				print(PageDoc, 110, end);
				System.out.println("\nNumber of comments :");
				print(PageDoc, 102, end);
				return;
			}

			catch (Exception e) {
				System.out.println("Exception occured");
			}
		}
		if (ForS == 5) {
			url = ("http://widgets.pinterest.com/v1/urls/count.json?source=6&url=" + Doc);
			System.out.println("Count :");
			coloncount = 3;
			end = '}';
		}
		PageDoc = getSource(url);
		print(PageDoc, coloncount, end);
	}

	/*
	 * This funcion is used to get the source from endpoint and convert it into
	 * a String
	 */
	static String getSource(String EndPoint) throws IOException {
		Document source = Jsoup.connect(EndPoint).ignoreContentType(true).get();
		String PageDoc = source.toString();
		return PageDoc;
	}

	/* This function prints the stats of the entered URL */
	static void print(String PageDoc, int fcount, char terminating) {

		int count = 0, i = 0;
		while (count < fcount) {
			if (PageDoc.charAt(i) == ':') {
				count++;
			}
			i++;
		}
		count = 0;
		while (PageDoc.charAt(i) != terminating) {
			System.out.print(PageDoc.charAt(i++));
		}
	}

}