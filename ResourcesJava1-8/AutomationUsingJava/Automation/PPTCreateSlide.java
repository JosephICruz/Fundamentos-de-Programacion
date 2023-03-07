package Automation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PPTCreateSlide {
   
   public static void main(String args[]) throws IOException {
   
      //creating presentation
      XMLSlideShow ppt = new XMLSlideShow();
      
      //getting the slide master object
      XSLFSlideMaster slideMaster = ppt.getSlideMasters()[0];
      
      //select a layout from specified list
      XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
      
      //creating a slide with title and content layout
      XSLFSlide slide = ppt.createSlide(slidelayout);
      //selection of title place holder
      XSLFTextShape title = slide.getPlaceholder(0);
      
      //setting the title in it
      title.setText("introduction");
      
      //selection of body placeholder
      XSLFTextShape body = slide.getPlaceholder(1);
      
      //clear the existing text in the slide
      body.clearText();
      
      
      String page = "https://en.wikipedia.org/wiki/Lists_of_countries_and_territories";
      //Connecting to the web page
      Connection conn = Jsoup.connect(page);
      //executing the get request
      Document doc = conn.get();
      //Retrieving the contents (body) of the web page
      String result = doc.body().text();
      
      System.out.println(result);
      
      String sbody=result.substring(0, 300);
      
      //adding new paragraph
      body.addNewTextParagraph().addNewTextRun().setText(sbody);
      
      
    //creating a second slide with title and content layout
      
      XSLFSlideMaster slideMaster2 = ppt.getSlideMasters()[0];
      slidelayout = slideMaster2.getLayout(SlideLayout.TITLE_AND_CONTENT);
      XSLFSlide slide2 = ppt.createSlide(slidelayout);
      //selection of title place holder
      XSLFTextShape title2 = slide2.getPlaceholder(0);
      
      //setting the title in it
      title2.setText("introduction - part 2");
      
      //selection of body placeholder
      XSLFTextShape body2 = slide2.getPlaceholder(1);
      
      //clear the existing text in the slide
      body2.clearText();
      
      sbody=result.substring(301, 600);
      
      //adding new paragraph
      body2.addNewTextParagraph().addNewTextRun().setText(sbody);
      
      //create a file object
      File file = new File("D:\\AutomationUsingJava\\Section 5 - Reading from a powerpoint presentation and creating a powerpoint\\contentlayout.pptx");
      FileOutputStream out = new FileOutputStream(file);
      
      //save the changes in a file
      ppt.write(out);
      System.out.println("slide created successfully");
      out.close();                
   }
}