package Automation;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteGetImages {
	
	public static void main(String args[]) throws IOException {

		Document doc = Jsoup.connect("http://h2020.myspecies.info/").get();  
		Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
		for (Element image : images) {  
		    System.out.println("src : " + image.attr("src"));  
		    System.out.println("height : " + image.attr("height"));  
		    System.out.println("width : " + image.attr("width"));  
		    System.out.println("alt : " + image.attr("alt"));  
		}  
	}
}





