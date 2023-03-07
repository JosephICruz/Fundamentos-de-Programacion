package Automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JavaBasicProgram1 {

	public static void main(String[] args) throws IOException {

		int i=10;
	    System.out.println("Hello"+"\n");
	    System.out.println(i);
	    System.out.println(i * 10);
	    
	    
        Properties props = new Properties();    
        props.put("name", "Karthik");  
        props.put("country", "India");  

        System.out.println(props.get("country"));
        
        
        FileInputStream file = new FileInputStream(new File("D:\\AutomationUsingJava\\Section 0 - Few Basic Java Programs\\SampleText.txt")); 
	    
        //System.out.println((char)file.read());
        
        int j = file.read();
        System.out.print(j);

       while(j != -1) {
           System.out.print((char)j);

           // Reads next byte from the file
           j = file.read();
        }
        file.close();
        
        char[] output =new char[100];
        
        BufferedReader is = new BufferedReader(new FileReader("D:\\AutomationUsingJava\\Section 0 - Few Basic Java Programs\\SampleText.txt"));
        
        //System.out.println("\n"+ (char)is.read());
        System.out.println("\n" + is.readLine());
	}

}
