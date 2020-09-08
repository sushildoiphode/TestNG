package DataProviderpack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class CSVfile {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		  String path="C:\\Users\\Dell\\Desktop\\CSVfile.csv";
		  File file=new File(path);
	      Reader read=new FileReader(path);
	      CSVReader csv=new CSVReader(read);
	      List<String[]> list=csv.readAll();
	      // System.out.println(list[0]);
	      Iterator<String[]> itr=list.iterator();
	     
	      while (itr.hasNext()) {
			String[] s=itr.next();
			for (int i = 0; i < s.length; i++) {
				System.out.print(s[i]+"     ");
			}
			System.out.println();
		}
	}
}
