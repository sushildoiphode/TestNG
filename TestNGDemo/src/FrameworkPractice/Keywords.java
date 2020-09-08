/* Project Name= Test Automation framework
 * Author= Sushil Doiphode
 * Client- Frnds
 * Organization- Testing Shashtra
 */
package FrameworkPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords {
	public static WebDriver driver;
	/**
	 * Open specified Web Browser
	 * @param openBrowser Browser name should only include Chrome,
	 * Firefox,Internate Explorer.No browser apart form mention is allowed.
	 */
	public static void keyWord(String openBrowser) {
		switch (openBrowser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "Firefox":
			driver=new FirefoxDriver();
			break;
		case "InternateExplorer":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		    break;
		default:
			System.out.println("Unable to load Browser");
			break;
		}
	}
	/**
	 * It opens the specified url in Web Browser recently open 
	 * by driver instance
	 * @param url {@code String} open to url
	 * return void
	 */
	public static void openURL() {
			driver.get("http://www.facebook.com/");
	}
	
	public static WebElement getWebElement(String locatorType,String locatorValue) {
		WebElement element = null;
		switch (locatorType) {
		case "XPATH":
			element=driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			element=driver.findElement(By.cssSelector(locatorValue));
			break;
		case "ID":
			element=driver.findElement(By.id(locatorValue));
			break;
		case "CLASSNAME":
			element=driver.findElement(By.className(locatorValue));
			break;
		case "LINKTEXT":
			element=driver.findElement(By.linkText(locatorValue));
			break;
		case "PARTIAL_LINK_TEXT":
			element=driver.findElement(By.partialLinkText(locatorValue));
			break;
		case "TAGNAME":
			element=driver.findElement(By.tagName(locatorValue));
			break;
		case "NAME":
			element=driver.findElement(By.name(locatorValue));
			break;

		default:
			System.err.println("Invalid Locator Type"+locatorType);
			break;
		}
		return element;
	}
	
	
	public static void enterText(String locatorType,String locatorValue,String textToEnter) {
		 getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
		}
	
	public static void clickOnElement(String locatorType,String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public static void setValueFromDropDown(String locatorType,String locatorValue,String text) {
			WebElement element=getWebElement(locatorType, locatorValue);
			Select s=new Select(element);
			s.selectByVisibleText(text);
	}
	public static void miximize() {
		driver.manage().window().maximize();
	}
	public static void closeWindow() {
		driver.close();

	}
		
}
