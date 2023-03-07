package Automation;

import java.net.URL;

public class WebsiteAccessibility {
    public static void main(String[] args) {
	     //URL u = new URL("https://google.com");
	
		  try {
		     (new java.net.URL("https://google.com")).openStream().close();

		     System.out.println("valid");
		  } catch (Exception ex) { 
		  System.out.println("not valid");  }
		}

}