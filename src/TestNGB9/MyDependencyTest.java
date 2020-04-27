package TestNGB9;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyDependencyTest {
	
	@Test
	public void mySetup() throws InterruptedException{
		System.out.println(" in setup ");
		Assert.assertTrue(false);
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods={"mySetup"})
	public void test() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("my test method");
	}
}
