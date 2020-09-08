package FrameworkPractice;

import java.sql.Driver;

import org.testng.annotations.Test;

public class tester {
	@Test
	public void	 m1() throws InterruptedException {
		Keywords.keyWord("Chrome");
		Keywords.openURL();
		Keywords.miximize();
		Keywords.enterText("NAME", "email", "Sushil doiphode");
		Keywords.enterText("ID", "pass", "123345");
		Keywords.clickOnElement("XPATH", "//div/a[@role='button']");
		Thread.sleep(2000);
		Keywords.setValueFromDropDown("ID", "day", "27");
		Keywords.setValueFromDropDown("ID", "month", "Nov");
		Keywords.setValueFromDropDown("ID", "year", "1992");
		Thread.sleep(2000);
		Keywords.closeWindow();
	}

}
