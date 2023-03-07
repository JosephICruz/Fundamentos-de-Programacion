package Automation;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;


public class PPTMerge {

public static void main(String args[]) throws IOException
{
XMLSlideShow ppt = new XMLSlideShow();
String[] inputs = {"D:\\AutomationUsingJava\\Section 5 - Reading from a powerpoint presentation and creating a powerpoint\\presentation1.pptx", "D:\\AutomationUsingJava\\Section 5 - Reading from a powerpoint presentation and creating a powerpoint\\presentation2.pptx"};
for(String arg : inputs){
    FileInputStream is = new FileInputStream(arg);
    XMLSlideShow src = new XMLSlideShow(is);
    is.close();
    for(XSLFSlide srcSlide : src.getSlides()){
        ppt.createSlide().importContent(srcSlide);
    }
}
FileOutputStream out = new FileOutputStream("D:\\AutomationUsingJava\\Section 5 - Reading from a powerpoint presentation and creating a powerpoint\\merged.pptx");
ppt.write(out);
out.close();
System.out.println("PPT files have been merged");
}
}