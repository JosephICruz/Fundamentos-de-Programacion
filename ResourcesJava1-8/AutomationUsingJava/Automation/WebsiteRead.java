package Automation;
import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class WebsiteRead {
   public static void main(String args[]) throws IOException {
      String page = "https://en.wikipedia.org/wiki/Lists_of_countries_and_territories";
      //Connecting to the web page
      Connection conn = Jsoup.connect(page);
      //executing the get request
      Document doc = conn.get();
      //Retrieving the contents (body) of the web page
      String result = doc.body().text();
      
      System.out.println(result);
   }
}