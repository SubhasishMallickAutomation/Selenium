package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demos_telerik10Countries {

	@Test
	public void testlistbox() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demos.telerik.com/aspnet-ajax/listbox/examples/overview/defaultvb.aspx");
	
		String countryArray[] = {"Canada", "Brazil", "Australia"};
		for (int i=0; i< countryArray.length; i++)
		{
			String srcXpath = getCountrySourceXpath(countryArray[i]);
			driver.findElement(By.xpath(srcXpath)).click();
			
			driver.findElement(By.xpath("//div/ul/li/button/span[@class='rlbButtonIcon rlbIconTransferRight']")).click();
			try{
				driver.findElement(By.xpath(getCountryDestiXpath(countryArray[i]))).click();
				//driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'Canada')]"));
			//	driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'India')]"));
				//System.out.println("Countries Found in Destination");
			}catch (Exception e){
				System.out.println(countryArray[i]+"not present in Destination");
			}
		}
	
	}

	public String getCountrySourceXpath(String conName) {
		return "//div[@id='ctl00_ContentPlaceholder1_RadListBoxSource']/div/ul/li[contains (text(),'"+conName+"')]";
	}
	
	public String getCountryDestiXpath(String conName) {
		return "//div[@id='ctl00_ContentPlaceholder1_RadListBoxDestination']/div/ul/li[contains (text(),'"+conName+"')]";
	}
}
