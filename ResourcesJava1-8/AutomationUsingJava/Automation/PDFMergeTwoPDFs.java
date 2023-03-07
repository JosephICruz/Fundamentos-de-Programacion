package Automation;

import org.apache.pdfbox.multipdf.PDFMergerUtility; 
import org.apache.pdfbox.pdmodel.PDDocument;  

import java.io.File; 
import java.io.IOException;  

public class PDFMergeTwoPDFs { 
   public static void main(String[] args) throws IOException { 
      
      //Loading an existing PDF document from the system path
      File file1 = new File("D:\\AutomationUsingJava\\Section 7 - Reading a pdf and displaying the content\\Sample.pdf"); 
      PDDocument doc1 = PDDocument.load(file1); 

      File file2 = new File("D:\\AutomationUsingJava\\Section 7 - Reading a pdf and displaying the content\\Sample2.pdf"); 
      PDDocument doc2 = PDDocument.load(file2); 
      
      File file3 = new File("D:\\AutomationUsingJava\\Section 7 - Reading a pdf and displaying the content\\Sample3.pdf"); 
      PDDocument doc3 = PDDocument.load(file3); 


      PDFMergerUtility PDFmerger = new PDFMergerUtility();       

      //Setting the destination file 
      PDFmerger.setDestinationFileName("D:\\AutomationUsingJava\\Section 7 - Reading a pdf and displaying the content\\merged.pdf"); 

      //adding the source files to be merged
      PDFmerger.addSource(file1); 
      PDFmerger.addSource(file2); 
      PDFmerger.addSource(file3); 

      //Merging the three documents 
      PDFmerger.mergeDocuments(); 
      System.out.println("Documents have been merged"); 

      //Closing the documents 
      doc1.close(); 
      doc2.close();        
      doc3.close(); 
   } 
}