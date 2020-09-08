package DataProviderpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ExcelPracticeHandling {
	@DataProvider(name="CredentialsData")
	public static Object[][] credentialsProvider() throws IOException{
	FileInputStream file=new FileInputStream("C:\\Users\\Dell\\Desktop\\Sushil.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file);
	XSSFSheet sheet=book.getSheet("Credentials");
	int lastRow=sheet.getLastRowNum();
	System.out.println(lastRow);
	
	int lastColumn=sheet.getRow(0).getLastCellNum();
	System.out.println(lastColumn);
	
	Object[][] obj=new Object[lastRow-1][lastColumn] ;
	
	for(int r=1; r<lastRow; r++) {
		Row row=sheet.getRow(r);
		
		for(int c=0; c<lastColumn; c++) {
			Cell cell=row.getCell(c);
			
			switch (cell.getCellType()) {
			case STRING:
				obj[r-1][c]=cell.getStringCellValue();
				break;
			case NUMERIC:
				obj[r-1][c]=cell.getNumericCellValue();
				break;
			case BLANK:
				obj[r-1][c]="";
				break;
			case FORMULA:
				obj[r-1][c]=cell.getCellFormula();
				break;
			case BOOLEAN:
				obj[r-1][c]=cell.getBooleanCellValue();
				break;

			default:
				break;
			}
		}
	}
	return obj;
	}
}


