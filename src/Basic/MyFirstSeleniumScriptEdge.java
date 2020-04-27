package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumScriptEdge {

	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "E:\\64\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://selenium.dev/");
		
		driver.findElement(By.xpath("//nav/a[contains(text(),'Downloads')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//nav/a[contains(text(),'Projects')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr/td/input[@name='search']")).sendKeys("selenium");
		Thread.sleep(2000);
		driver.findElement(By.name("search")).sendKeys("automation");
		
		
		boolean result = true;
		String msg = " ";
		
		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//nav/a[contains(text(),'Documentation')]"));
		}catch (Exception e){
			System.out.println("documentation tab missing");
			result = false;
			msg = msg + "documentation tab missing";
		}

		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//nav/a[contains(text(),'Support')]"));
		}catch (Exception e){
			System.out.println("support tab missing");
			result = false;
			msg = msg + "support tab missing";
		}

		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//nav/a[contains(text(),'BlogXX')]"));
		}catch (Exception e){
			System.out.println("blog tab missing");
			result = false;
			msg = msg + "blog tab missing";
		}
		
		Assert.assertTrue(result, msg);
	}

}
