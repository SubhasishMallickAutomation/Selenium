package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demos_telerik {

	@Test
	public void telerik() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demos.telerik.com/aspnet-ajax/listbox/examples/overview/defaultvb.aspx");
	
	driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxSource']/div/ul/li[contains (text(),'Australia')]")).click();
	driver.findElement(By.xpath("//div/ul/li/button/span[@class='rlbButtonIcon rlbIconTransferRight']")).click();
	
	try{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'Australia')]"));
	}catch (Exception e){
		System.out.println("Failed : Element not found in Destination");
	}
  }
}
