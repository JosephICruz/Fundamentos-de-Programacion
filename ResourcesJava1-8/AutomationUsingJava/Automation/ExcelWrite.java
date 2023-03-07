package Automation;

//import statements 
import java.io.*; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row; 
import java.io.File; 
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.apache.poi.xssf.usermodel.XSSFSheet;
public class ExcelWrite { 
public static void main(String[] args) 
	{ 
		// Blank workbook 
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		// Create a blank sheet 
		XSSFSheet sheet = workbook.createSheet("Employee Details"); 

		// This data needs to be written (Object[]) 
		Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
		data.put("1", new Object[]{ "ID", "Name", "City" }); 
		data.put("2", new Object[]{ 1, "John", "New York" }); 
		data.put("3", new Object[]{ 2, "David", "New Jersey" }); 
		data.put("4", new Object[]{ 3, "Michael", "Chicago" }); 
		data.put("5", new Object[]{ 4, "Andy", "Phoenix" }); 

		// Iterate over data and write to sheet 
		Set<String> keyset = data.keySet(); 
		int rownum = 0; 
		for (String key : keyset) { 
			// this creates a new row in the sheet 
			Row row = sheet.createRow(rownum++); 
			Object[] objArr = data.get(key); 
			int cellnum = 0; 
			for (Object obj : objArr) { 
				// this line creates a cell in the next column of that row 
				Cell cell = row.createCell(cellnum++); 
				if (obj instanceof String) 
					cell.setCellValue((String)obj); 
				else if (obj instanceof Integer) 
					cell.setCellValue((Integer)obj); 
			} 
		} 
		try { 
			// this Writes the workbook 
			FileOutputStream out = new FileOutputStream(new File("D:\\AutomationUsingJava\\Section 4 - Reading and Writing data into an excel file\\ExcelOutput.xlsx")); 
			workbook.write(out); 
			out.close(); 
			workbook.close();
			System.out.println("file written successfully on disk."); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 
