package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyiFrame {
	@Test
	public void frame() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		WebElement fr = driver.findElement(By.xpath("//div/iframe[@name='iframe2']"));
		driver.switchTo().frame(fr);
		//driver.switchTo().frame("iframe2");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li/a[contains(text(),'Sortable')]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

}
