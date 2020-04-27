package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demos_telerik1 {

	@Test
	public void telerik() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demos.telerik.com/aspnet-ajax/listbox/examples/overview/defaultvb.aspx");
	
	driver.findElement(By.xpath("//span[@class='rlbButtonIcon rlbIconTransferAllRight']")).click();
	
	try{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'Australia')]"));
		driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'Canada')]"));
		driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'India')]"));
		System.out.println("Countries Found in Destination");
	}catch (Exception e){
		System.out.println("Failed : Element not found in Destination");
	}
	}
  
}
