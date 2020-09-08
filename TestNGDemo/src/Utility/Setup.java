package Utility;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	String env="";
	String baseurl;
	WebDriver driver;
	long startTime, endTime;
	
	@BeforeSuite
	public void startTime() {
		startTime=System.currentTimeMillis();
	}
	@Parameters("browserName")
	@BeforeTest
	public void OpenBrowser(String browserName) {
		startTime=System.currentTimeMillis();
		System.out.println("Launching browser");
		env=System.getProperty("env");
		if(env.equals("beta")) {
			baseurl="http://beta.testingshashtra.com";
		}else if (env.equals("dev")) {
			baseurl="http://dev.testingshashtra.com";
		}
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "Opera":
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
			break;
		case "InternateExplorer":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		default:
			System.out.println("Invalied browser name");
			break;
		}
		System.out.println("Opening a Browser");
		driver.get("http://www.testingshastra.com/");
		}
	
	@BeforeClass
	public void SignIN() {
		System.out.println("Sign-in");
	}
	@AfterClass
	public void SignOut(){
		System.out.println("Sign-Out");
	}
	@AfterSuite
	public void endTime() {
		endTime=System.currentTimeMillis();
		long diff=endTime-startTime;
		System.out.println("Time taken "+diff);
	}

}
