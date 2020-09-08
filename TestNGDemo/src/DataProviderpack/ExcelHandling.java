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

public class ExcelHandling {
	@DataProvider(name="CredentialsData")
	public static Object[][] credentialsProvider() throws IOException{
	FileInputStream file=new FileInputStream("C:\\Users\\Dell\\Desktop\\Sushil1.xlsx");
	XSSFWorkbook book=new XSSFWorkbook(file);
	XSSFSheet sheet=book.getSheet("Credentials");
	int lastRow=sheet.getLastRowNum();
	System.out.println(lastRow);
	
	
	int lastColumn=sheet.getRow(0).getLastCellNum();
	System.out.println(lastColumn);
	
	Object[][] obj=new Object[lastRow+1][lastColumn] ;
	
	for(int r=0; r<lastRow+1; r++) {
		Row row=sheet.getRow(r);
		for(int c=0; c<lastColumn; c++) {
			Cell cell=row.getCell(c);
			obj[r][c]=cell.getStringCellValue();
			//System.out.println(cell.getStringCellValue());
		}
	}
	return obj;
	}
}

