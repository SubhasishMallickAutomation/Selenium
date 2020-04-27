package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadDocument {
	WebDriver driver;

	@Test(priority = 1)
	//Case 1 : if the user directly clicks on the "download MyDoc" without clicking on "terms and conditions", an HTTP 403 error is returned.
	public void directDownloadMyDoc() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://example.com/doc.html");
		driver.findElement(By.xpath("//div/a[@id='mydocpdf']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("error"));
		driver.close();

	}
	
	@Test(priority = 2)
	//Case 2 : user clicks "I Accept", then clicking on "download MyDoc" -Valid case
	public void acceptAndDownloadMyDoc() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://example.com/doc.html");
		
		driver.findElement(By.xpath("//div/a[contains(text(),'terms and conditions')]")).click();
		driver.findElement(By.xpath("//div/form/input[@id='accept']")).click();
	
		driver.findElement(By.xpath("//div/a[@id='mydocpdf']")).click();
		
	}
	
	@Test(priority = 3)
	//Case 3 : user clicks "I do not Accept", then clicking on "download MyDoc"
	public void rejectAndDownloadMyDoc() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://example.com/doc.html");
		
		driver.findElement(By.xpath("//div/a[contains(text(),'terms and conditions')]")).click();
		driver.findElement(By.xpath("//div/form/input[@id='reject']")).click();

		driver.findElement(By.xpath("//div/a[@id='mydocpdf']")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("error"));
		driver.close();
	}
}
