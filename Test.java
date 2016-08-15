import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Scanner;

public class Test {

	/* Main Function */
	public static void main(String[] args) throws IOException {

		System.out.println("1.Facebook 2.LinkedIN");
		Scanner In = new Scanner(System.in);
		int choice = In.nextInt();
		Site(choice);

	}
	
	static void Site(int choice){
		
		switch(choice)
		{
		case 1 : inputFB();
		case 2 : inputLinkedIN();
		}
	}
	/*
	 * This function takes a URL of a page as input and inserts it into the
	 * endpoint link
	 */
	static void inputFB() {

		Scanner b = new Scanner(System.in);
		System.out.println("URL of page");
		String PageURL = b.nextLine();
		String url = ("https://api.facebook.com/method/links.getStats?urls=%%" + PageURL + "%%&format=json");
		Document doc = Jsoup.connect(PageURL).ignoreContentType(true).get();
		String PageDoc = doc.toString();
		System.out.println("Number of Likes : ");
		printFBLikes(PageDoc);
	}
	
	static void inputLinkedIN() {

		Scanner b = new Scanner(System.in);
		System.out.println("URL of page");
		String PageURL = b.nextLine();
		String url = ("https://www.linkedin.com/countserv/count/share?format=json&url=" + PageURL);
		Document doc = Jsoup.connect(PageURL).ignoreContentType(true).get();
		String PageDoc = doc.toString();
		System.out.println("Number of Likes : ");
		printLinkedIN(PageDoc);
	}

	/*
	 * This function takes the whole Document of the endpoint link as an input
	 * with data type String and prints out the number of likes on the page.
	 */
	static void printFBLikes(String Doc) {

		int count = 0, i = 0;
		while (count < 6) {
			if (Doc.charAt(i) == ':') {
				count++;
			}
			i++;
		}
		count = 0;
		while (Doc.charAt(i) != ',') {
			System.out.print(a.charAt(i++));
		}
	}
	static void printLinkedIN(String Doc) {

		int count = 0, i = 0;
		while (count < 1) {
			if (Doc.charAt(i) == ':') {
				count++;
			}
			i++;
		}
		count = 0;
		while (Doc.charAt(i) != ',') {
			System.out.print(a.charAt(i++));
		}
	}

}
