import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;

import java.util.Scanner;
public class Test {
	public static void main( String[] args ) throws IOException{  
		String U = input();
        Document doc = Jsoup.connect(U).ignoreContentType(true).get();
        String title = doc.toString();
        System.out.println("Number of Likes : ");
        printLikes(title);
}

	static String input(){
		Scanner b = new Scanner(System.in); 
		System.out.println("URL of page");
		String s=b.nextLine();
		String url = ("https://api.facebook.com/method/links.getStats?urls=%%" + s + "%%&format=json");
		return url;
	}
	static void printLikes (String a){
		int count=0,i=0;
		while(count<6)
		{
			if(a.charAt(i)==':')
			{
				count++;
			}
			i++;
		}
		count=0;
		while(a.charAt(i)!=',')
		{
		System.out.print(a.charAt(i++));
		}
	}
}
