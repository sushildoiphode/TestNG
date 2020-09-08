package Test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import DataProviderpack.DataFeeder;
import DataProviderpack.ExcelHandling;
import DataProviderpack.ExcelPracticeHandling;
import DataProviderpack.csvfiletestng;
import Utility.Setup;

@Test
public class SmokeTest {
	@Test(dataProvider="CredentialsData",dataProviderClass = ExcelHandling.class)
	public void m1(Double no,String uname,Double pass){
		System.out.println(no+" "+uname+" "+pass+" ");
	}
	public void m2(){
		System.out.println("I am Second Smoke TestCase");
	}
	public void m3(){
		System.out.println("I am Third Smoke TestCase");
	}
	public void m4(){
		System.out.println("I am Fourth Smoke TestCase");
	}

}
