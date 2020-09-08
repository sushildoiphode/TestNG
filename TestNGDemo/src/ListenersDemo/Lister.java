package ListenersDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(MyListeners.class)
public class Lister {
	@Test
	public void m1() {
		System.out.println("First Test case");
	}
	@Test
	public void m2() {
		System.out.println("Second Test case");
		Assert.assertEquals("hii", "Hello");
	}
	@Test
	public void m3() {
		System.out.println("Third Test case");
	}
	@Test
	public void m4() {
		System.out.println("Fourth Test case");
	}
	@Test
	public void m5() {
		System.out.println("Fifth Test case");
	}
	@Test
	public void m6() {
		System.out.println("Six Test case");
	}
	@Test
	public void m7() {
		System.out.println("Seven Test case");
	}
	

}
