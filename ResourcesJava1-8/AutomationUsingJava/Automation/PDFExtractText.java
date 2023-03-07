package Automation;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class PDFExtractText {
   public static void main(String args[]) throws IOException {
      //Loading an existing document
      File file = new File("D:\\AutomationUsingJava\\Section 7 - Reading a pdf and displaying the content\\Sample2.pdf");
      PDDocument document = PDDocument.load(file);

      PDFTextStripper pdfStripper = new PDFTextStripper();
      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);

      System.out.println(text);
      //Closing the document
      document.close();
   }
}