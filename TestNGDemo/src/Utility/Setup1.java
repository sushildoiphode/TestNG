package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup1 {
	String env="";
	String baseUrl;
	@BeforeSuite
	public void openBrowser() {
		env=System.getProperty("env");
		if (env.equals("beta")) {
			baseUrl="http://beta.testingshastra.com";
		} else if(env.equals("dev")) {
			baseUrl="http://dev.testingshastra.com";
		}
		System.out.println("Opening a browser");
	}
	@BeforeTest
	public void LaunchUrl() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(baseUrl);
		
		System.out.println("Launching URL");
	}
	@BeforeClass
	public void SignIn() {
		System.out.println("Signing In");
	}
	@AfterClass
	public void SignOut() {
		System.out.println("Signing Out");
	}
}


