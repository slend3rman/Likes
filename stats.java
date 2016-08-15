
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Scanner;

public class stats {

	/* Main Function */
	public static void main(String[] args) throws IOException {
		
		int choice;
		do {
			System.out.println("\n1.Facebook \n2.LinkedIN\n3.Stumbled Upon\n4.Exit");
			Scanner In = new Scanner(System.in);
			choice = In.nextInt();
			Site(choice);
		} while (choice != 4);

	}

	/*This Function uses the choice of the user as a parameter
	 * and decides which site to access accordingly
	 */
	static void Site(int choice) throws IOException {

		switch (choice) {
		case 1:
			String PageDoc = input();
			FBorS(PageDoc, 1);
			break;
		case 2:
			PageDoc = input();
			FBorS(PageDoc, 3);
			break;
		case 3:
			PageDoc = input();
			FBorS(PageDoc, 2);
			break;
		}
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
	 * with data type String and calls the print function
	 */
	static void FBorS(String Doc, int ForS) throws IOException {
		String url = ",";
		if (ForS == 1) {
			url = ("https://api.facebook.com/method/links.getStats?urls=%%" + Doc + "%%&format=json");
			System.out.println("Number of Likes : ");
		}
		if (ForS == 2) {
			url = ("http://www.stumbleupon.com/services/1.01/badge.getinfo?url=" + Doc);
			System.out.println("Number of Views : ");
		}
		int coloncount = 6;
		if (ForS == 3) {
			url = ("https://www.linkedin.com/countserv/count/share?format=json&url=" + Doc);
			coloncount = 1;
		}
		Document source = Jsoup.connect(url).ignoreContentType(true).get();
		String PageDoc = source.toString();
		Print(PageDoc, coloncount);
	}

	/* This function prints the stats of the entered URL */
	static void Print(String PageDoc, int fcount) {

		int count = 0, i = 0;
		while (count < fcount) {
			if (PageDoc.charAt(i) == ':') {
				count++;
			}
			i++;
		}
		count = 0;
		while (PageDoc.charAt(i) != ',') {
			System.out.print(PageDoc.charAt(i++));
		}
	}

}