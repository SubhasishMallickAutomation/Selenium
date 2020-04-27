package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstSeleniumScriptCH {

	@Test
	public void MyFirstSeleniumScript() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
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
