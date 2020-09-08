package Test1;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Setup;


public class RegressionTest  {
	@Test(enabled = true)
	public void m1(){
		System.out.println("I am first Regression TestCase");
	}
	@Test(invocationCount = 4)
	public void m2(){
		System.out.println("I am Second Regression TestCase");
	}
	@Test(expectedExceptions =FileNotFoundException.class)
	public void m3(){
		System.out.println("I am Third Regression TestCase");
		int i=10;
		int s=i/0;
	}
	@Test
	public void m4(){
		System.out.println("I am Fourth Regression TestCase");
	}

}
