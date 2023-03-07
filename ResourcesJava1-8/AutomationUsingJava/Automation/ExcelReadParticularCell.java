package Automation;

//reading value of a particular cell  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadParticularCell {
	
	public static void main(String[] args) {		
		ExcelReadParticularCell rc = new ExcelReadParticularCell(); // object of the class
		
		//reading the value of 3rd row , 2nd column from the second sheet		
		
		String value = null; // variable for storing the cell value
		Workbook wb = null; // initialize Workbook null
		try {
			//reading data from a file in the form of bytes  
			FileInputStream fis = new FileInputStream(
					"D:\\AutomationUsingJava\\Section 4 - Reading and Writing data into an excel file\\ExcelReadInput.xlsx");
			//constructs an XSSFWorkbook object, by buffering the whole stream into the memory  
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet = wb.getSheetAt(1); // getting the XSSFSheet object at given index
		Row row = sheet.getRow(3); // returns the logical row
		Cell cell = row.getCell(2); // getting the cell representing the given column


		System.out.println(cell);
	}


}
