package Test1;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.Setup;


public class SanityTest {
	@Test(groups = {"Sanity"})
	public void m1(){
		System.out.println("I am first Sanity TestCase");
	}
	@Test(dependsOnGroups = {"Sanity"})
	public void m2(){
		System.out.println("I am Second Sanity TestCase");
	}
	@Test()
	public void m3(){
		System.out.println("I am Third Sanity TestCase");
		Assert.assertEquals("A","A");
		System.out.println("A test done");
		
	}
	int count=5;
	@Test(invocationCount = 10, successPercentage = 50,description = "Count 10 times")
	public void m4(){
		System.out.println("I am Fourth Sanity TestCase"+count);
		//count++;
		Assert.assertEquals(count, 5);
	}
}
