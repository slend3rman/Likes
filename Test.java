import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Scanner;

public class Test {

	/* Main Function */
	public static void main(String[] args) throws IOException {

		String PageURL = input();
		Document doc = Jsoup.connect(PageURL).ignoreContentType(true).get();
		String PageDoc = doc.toString();
		System.out.println("Number of Likes : ");
		printLikes(PageDoc);
	}

	/*
	 * This function takes a URL of a page as input and inserts it into the
	 * endpoint link
	 */
	static String input() {

		Scanner b = new Scanner(System.in);
		System.out.println("URL of page");
		String PageURL = b.nextLine();
		String url = ("https://api.facebook.com/method/links.getStats?urls=%%" + PageURL + "%%&format=json");
		return url;
	}

	/*
	 * This function takes the whole Document of the endpoint link as an input
	 * with data type String and prints out the number of likes on the page.
	 */
	static void printLikes(String Doc) {

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

}
