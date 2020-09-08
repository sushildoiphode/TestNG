package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test123 {
	WebDriver driver;
	@BeforeTest
	public void Lanuch() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		System.out.println("Launch Browser of Facebook - Before Test");
	}
	@BeforeSuite
	public void creat() {
		System.out.println("facebook Test Case");
	}
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("sushildoiphode");
		driver.findElement(By.id("pass")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@aria-label='Log In']")).click();
		System.out.println("Login facebook done");
	}
	@AfterSuite
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Close the browser");
	}
	@AfterTest
	public void afteras() {
		System.out.println("After test done");
	}
	@BeforeMethod
	public void asd() {
		System.out.println("Before method");

	}
	
	

}
