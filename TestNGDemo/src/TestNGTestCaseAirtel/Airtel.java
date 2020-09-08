package TestNGTestCaseAirtel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Airtel {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airtel.in/");
		driver.manage().deleteAllCookies();
		Thread.sleep(10000);
		//Popup handling 
		driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-block']")).click();
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void verifyHomePageVisibilityTest() {
		String s=driver.getCurrentUrl();
		String url="https://www.airtel.in/";
		Assert.assertEquals(s,url);
		System.out.println("Home page should be visible to the end user");
	}
	@Test
	public void verifyTitleTest() {
		String title=driver.getTitle();
		String s="Airtel 4G - Prepaid | Postpaid | Broadband | Payments Bank| DTH";
		Assert.assertEquals(title, s);
		System.out.println("\"Airtel 4G - Prepaid | Postpaid | Broadband | Payments Bank"
				+ "| DTH\" this title should be visible on title bar on home page.");
	}
	@Test
	public void verifyLogoVisibilityTest() {
		boolean logoImage=driver.findElement(By.xpath("//img[@class='brand']")).isDisplayed();
		Assert.assertTrue(logoImage);
		driver.findElement(By.xpath("//img[@class='brand']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Airtel logo should be visible at left upper corner and clickable.");
		
		
	}
	@Test
	public void verifyXstreamVisibilityTest() {
		boolean xstreamText=driver.findElement(By.xpath("//a[@data-analytics='header|Xstream']")).isDisplayed();
		Assert.assertTrue(xstreamText); 
		driver.findElement(By.xpath("//a[@data-analytics='header|Xstream']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtelxstream.in/?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("XSTREAM link should be visible and clickable on top link bar.");
	}
	@Test
	public void verifyAirtel_Payments_Bank_VisibilityTest() {
		boolean text=driver.findElement(By.xpath("//a[@data-analytics='header|Airtel Payments Bank']")).isDisplayed();
		Assert.assertTrue(text);
		driver.findElement(By.xpath("//a[@data-analytics='header|Airtel Payments Bank']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/bank/?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Airtel Payments Bank link should be visible and clickable on top link bar.");
	}
	@Test
	public void verifyWynkVisibilityTest() {
		boolean WynkText=driver.findElement(By.xpath("//a[@data-analytics='header|Wynk']")).isDisplayed();
		Assert.assertTrue(WynkText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Wynk']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://wynk.in/music?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Wynk link should be visible and clickable on top link bar.");
	}
	@Test
	public void verifyPersonalVisibilityTest() {
		String personalText=driver.findElement(By.xpath("//a[@data-analytics='header|Personal']")).getText();
		Assert.assertEquals(personalText, "Personal");
		System.out.println("Personal text should be visible on top link bar.");
	}
	@Test
	public void verifyCareerVisibilityTest() {
		boolean careerText=driver.findElement(By.xpath("//a[@data-analytics='header|Career']")).isDisplayed();
		Assert.assertTrue(careerText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Career']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/careers/?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Career link is visible and clickable on top link bar.");
	}
	@Test
	public void verifyBusinessVisibilityTest() {
		boolean BusinessText=driver.findElement(By.xpath("//a[@data-analytics='header|Business']")).isDisplayed();
		Assert.assertTrue(BusinessText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Business']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/business/#/?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Business link should be visible and clickable on top link bar.");
	}
	@Test
	public void verifyInvestorVisibilityTest() {
		boolean investorText=driver.findElement(By.xpath("//a[@data-analytics='header|Investor']")).isDisplayed();
		Assert.assertTrue(investorText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Investor']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/about-bharti/equity?icid=hheader";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Investor link should be visible and clickable on top link bar.");
	}
	
	/*
	@Test
	public void verifyAlertVisibilityTest() {
		boolean alert=driver.findElement(By.xpath("//div[@class='moe-popup-container']")).isDisplayed();
		Assert.assertTrue(alert);
		System.out.println("Alert massage box is available on homepage.");
	}
	@Test
	public void verifyalert_logo_VisibilityTest() {
		boolean alertLogo=driver.findElement(By.xpath("//div/img[@src='https://assets.airtel.in/static-assets/new-"
													+ "home/img/airtel-red.svg?v=1597833200902']")).isDisplayed();
		Assert.assertTrue(alertLogo);
		System.out.println("Airtel Logo should be displayed on alert massage box.");
	}
	@Test
	public void verify_alert_Text1VisibilityTest() {
		String text=driver.findElement(By.xpath("//div[@class='moe-text-container']/h3")).getText();
		Assert.assertEquals(text, "Keep up-to-date & get notified!");
		System.out.println("Keep up-to-date & get notified! text should be visible on alert massage box.");
	}
	@Test
	public void verify_alert_Text2VisibilityTest() {
		String text=driver.findElement(By.xpath("//div[@class='moe-text-container']/p")).getText();
		Assert.assertEquals(text, "You can turn these off anytime you want");
		System.out.println("You can turn these off anytime you want text should be visible on alert massage box.");
	}
	@Test
	public void verifyalert_DontAllowbutton_VisibilityTest() {
		boolean dontAllow=driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-block']")).isDisplayed();
		Assert.assertTrue(dontAllow);
		driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-block']")).click();
		boolean dontAllow1=driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-block']")).isDisplayed();
		Assert.assertFalse(dontAllow1);
		System.out.println("Don't Allow button should be displayed and clickable on alert massage box.");
	}
	@Test
	public void verifyalert_Allowbutton_VisibilityTest() {
		boolean allow=driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-allow']")).isDisplayed();
		Assert.assertTrue(allow);
		driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-allow']")).click();
		boolean allow1=driver.findElement(By.xpath("//button[@class='moe-btn moe-btn-allow']")).isDisplayed();
		Assert.assertFalse(allow1);
		System.out.println("Allow button should be displayed and clickable on alert massage box.");
	}
	
	*/
	
	@Test
	public void verifyPrepaidVisibilityTest() {
		boolean prepaid=driver.findElement(By.xpath("//h3[text()='PREPAID']")).isDisplayed();
		Assert.assertTrue(prepaid);
		System.out.println("PREPAID heading text should be available on header list of homepage");
	}
	@Test
	public void verifyPostpaidVisibilityTest() {
		boolean postpaid=driver.findElement(By.xpath("//h3[text()='POSTPAID']")).isDisplayed();
		Assert.assertTrue(postpaid);
		System.out.println("POSTPAID heading text should be available on header list of homepage");
	}
	@Test
	public void verifyBroadbandVisibilityTest() {
		boolean broadband=driver.findElement(By.xpath("//h3[text()='BROADBAND']")).isDisplayed();
		Assert.assertTrue(broadband);
		System.out.println("BROADBAND heading text should be available on header list of homepage");
	}
	@Test
	public void verifyDTHVisibilityTest() {
		boolean dth=driver.findElement(By.xpath("//h3[text()='DTH']")).isDisplayed();
		Assert.assertTrue(dth);
		System.out.println("DTH heading text should be available on header list of homepage");
	}
	@Test
	public void verifyBankVisibilityTest() {
		boolean bank=driver.findElement(By.xpath("//h3[text()='BANK']")).isDisplayed();
		Assert.assertTrue(bank);
		System.out.println("BANK heading text should be available on header list of homepage");
	}
	@Test
	public void verifyHelpVisibilityTest() {
		boolean help=driver.findElement(By.xpath("//h3[text()='HELP']")).isDisplayed();
		Assert.assertTrue(help);
		System.out.println("HELP heading text should be available on header list of homepage");
	}
	@Test
	public void verifyGetAppVisibilityTest() {
		boolean getAppText=driver.findElement(By.xpath("//a[@data-analytics='header|Get App']")).isDisplayed();
		Assert.assertTrue(getAppText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Get App']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/airtel-thanks-app?icid=header";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Get App Image link is available and clickable on header line.");  
	}
	@Test
	public void verifyAirtelStoreVisibilityTest() {
		boolean airtelStoreText=driver.findElement(By.xpath("//a[@data-analytics='header|Airtel Store']")).isDisplayed();
		Assert.assertTrue(airtelStoreText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Airtel Store']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/store/";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Airtel Store Image link is available and clickable on header line.");  
	}
	@Test
	public void verifyLoginVisibilityTest() {
		boolean loginText=driver.findElement(By.xpath("//a[@data-analytics='header|Login']")).isDisplayed();
		Assert.assertTrue(loginText);
		driver.findElement(By.xpath("//a[@data-analytics='header|Login']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/s/selfcare?normalLogin";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Login Image link is available and clickable on header line.");  
	}
	@Test
	public void verifytext1RechargeTabVisibilityTest() {
		String text=driver.findElement(By.xpath("//h4[text()='Recharge & Pay bills']")).getText();
		Assert.assertEquals(text, "Recharge & Pay bills");
		System.out.println("'Recharge & Pay bills' text should be visible on Recharge tab of home page.");
	}
	@Test
	public void verifytext2RechargeTabVisibilityTest() {
		String text=driver.findElement(By.xpath("//p[text()='Get exciting cashback and offers']")).getText();
		Assert.assertEquals(text, "Get exciting cashback and offers");
		System.out.println("'Get exciting cashback and offers' text should be visible on Recharge tab of home page.");
	}
	@Test
	public void verifyPrepaidtextvisibility() {
		boolean prepaid=driver.findElement(By.xpath("//li[@lob='Prepaid']")).isDisplayed();
		Assert.assertTrue(prepaid);
		System.out.println("Prepaid image link is visible and clickable on recharge tab of home page");
	}
	@Test
	public void verifyPostpaidtextvisibility() {
		boolean postpaid=driver.findElement(By.xpath("//li[@lob='Postpaid']")).isDisplayed();
		Assert.assertTrue(postpaid);
		System.out.println("Postpaid image link is visible and clickable on recharge tab of home page");
	}
	@Test
	public void verifyDTHtextvisibility() {
		boolean dth=driver.findElement(By.xpath("//li[@lob='DTH']")).isDisplayed();
		Assert.assertTrue(dth);
		System.out.println("DTH image link is visible and clickable on recharge tab of home page");
	}
	@Test
	public void verifyBroadbandtextvisibility() {
		boolean broadBand=driver.findElement(By.xpath("//li[@lob='Broadband']")).isDisplayed();
		Assert.assertTrue(broadBand);
		System.out.println("Broadband image link is visible and clickable on recharge tab of home page");
	}
	@Test
	public void verifyTextBoxVisibilityText() {
		boolean broadBand=driver.findElement(By.name("recharge")).isDisplayed();
		Assert.assertTrue(broadBand);
		System.out.println("Textbox is available on recharge tab of home page");
	}
	
	@Test
	public void verifyBuy_Prepaid_VisibilityTest() {
		boolean buyPerpaid=driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy prepaid']")).isDisplayed();
		Assert.assertTrue(buyPerpaid);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy prepaid']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/prepaid-4g-sim/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Buy Prepaid Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_Postpaid_VisibilityTest() {
		boolean buyPostpaid=driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy postpaid']")).isDisplayed();
		Assert.assertTrue(buyPostpaid);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy postpaid']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/myplan-infinity/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Buy Postpaid Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_Broadband_VisibilityTest() {
		boolean buyBroadband=driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy broadband']")).isDisplayed();
		Assert.assertTrue(buyBroadband);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy broadband']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/broadband/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Buy Broadband Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_DTH_VisibilityTest() {
		boolean buyDTH=driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy dth']")).isDisplayed();
		Assert.assertTrue(buyDTH);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy dth']")).click();
		String newTitle=driver.getTitle();
		String expectedTitle="Buy Airtel DTH Plans in Pune | Get HD / SD DTH Box, Xstream Box DTH Online";
		Assert.assertEquals(newTitle, expectedTitle);
		System.out.println("Buy DTH Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_Xstream_VisibilityTest() {
		boolean buyXstream=driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy xstream']")).isDisplayed();
		Assert.assertTrue(buyXstream);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-buy xstream']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/xstream/box?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Buy Xstream Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verify_Port_to_Airtel_VisibilityTest() {
		boolean Port=driver.findElement(By.xpath("//a[@data-analytics='airtel services-port to airtel']")).isDisplayed();
		Assert.assertTrue(Port);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-port to airtel']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/mnp/?requirement=MNP&utm_source=MNP_direct&icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Buy Port to Airtel Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_Prepaid_to_Postpaid_VisibilityTest() {
		boolean buyPort=driver.findElement(By.xpath("//a[@data-analytics='airtel services-prepaid to postpaid']")).isDisplayed();
		Assert.assertTrue(buyPort);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-prepaid to postpaid']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/myplan-infinity/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Prepaid to Postpaid Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_One_Airtel_Plan_VisibilityTest() {
		boolean buyPort=driver.findElement(By.xpath("//a[@data-analytics='airtel services-One Airtel Plan']")).isDisplayed();
		Assert.assertTrue(buyPort);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-One Airtel Plan']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/one-airtel-plan/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("One Airtel Plan Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verifyBuy_Airtel_Payments_Bank_VisibilityTest() {
		boolean name=driver.findElement(By.xpath("//a[@data-analytics='airtel services-airtel payments bank']")).isDisplayed();
		Assert.assertTrue(name);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-airtel payments bank']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/bank/?utm_source=Internal&utm_medium=QuickAction&utm_campaign=Airtel&icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Airtel Paymants Bank Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verify_International_RoamingVisibilityTest() {
		boolean name=driver.findElement(By.xpath("//a[@data-analytics='airtel services-international roaming']")).isDisplayed();
		Assert.assertTrue(name);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-international roaming']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/ir-packs/?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("International Roaming Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verify_Business_Postpaid_VisibilityTest() {
		boolean name=driver.findElement(By.xpath("//a[@data-analytics='airtel services-business postpaid']")).isDisplayed();
		Assert.assertTrue(name);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-business postpaid']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/business/b2b/postpaid-with-g-suite";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("Business Postpaid Image link is available and clickable on quick-actions-container.");  
	}
	@Test
	public void verify_WiFi_Calling_VisibilityTest() {
		boolean name=driver.findElement(By.xpath("//a[@data-analytics='airtel services-wifi calling']")).isDisplayed();
		Assert.assertTrue(name);
		driver.findElement(By.xpath("//a[@data-analytics='airtel services-wifi calling']")).click();
		String newUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.airtel.in/wifi-calling?icid=quick_action";
		Assert.assertEquals(newUrl, expectedUrl);
		System.out.println("WiFi Calling Image link is available and clickable on quick-actions-container.");  
	}

	
}
