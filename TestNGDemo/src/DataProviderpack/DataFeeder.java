package DataProviderpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataFeeder {
	
	  @DataProvider(name = "CredentialsData")
	   public static Object[][] LoginCredentials(){ 
	   Object[][] obj = { {"Sushil","1234"},
			   			  {"Deepak","8565"},
			   			  {"Ram","8965"},
			   			  {"Vishal","5866"}
	  
	  }; 
	   return obj;
	 
	}
}
