package DataProviderpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;


import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

public class csvfiletestng {
	@DataProvider(name="CredentialsData")
	public static Object[][] credentialsProvider() throws IOException {
		 String path="C:\\Users\\Dell\\Desktop\\CSVfile.csv";
		  File file=new File(path);
	      Reader read=new FileReader(path);
	      CSVReader csv=new CSVReader(read);
	      List<String[]> list=csv.readAll();
	      Iterator<String[]> itr=list.iterator();
	      while (itr.hasNext()) {
			String[] s=itr.next();
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i]+"     ");
			}System.out.println();
	      }
	      return obj;    
	}
}
