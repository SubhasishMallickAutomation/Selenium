package Advanced;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyMultipleWindow {
	
	@Test
	public void window() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wiziq.com/tutorial/810773-selenium-presentation-updated#");
		
		driver.findElement(By.xpath("//div/a/span[contains(text(),'Login with Facebook')]")).click();
		
		String ParentWin = driver.getWindowHandle();
		Set<String> totalWins = driver.getWindowHandles();
		String Childwin = null;
		
		for (String singleWin : totalWins) {
			if (!ParentWin.equals(singleWin)){
				Childwin=singleWin;
			}
		}
		
		driver.switchTo().window(Childwin);
		driver.findElement(By.xpath("//div/div/input[@name='email']")).sendKeys("selenium@gmail.com");
		driver.findElement(By.xpath("//div/div/input[@name='pass']")).sendKeys("testautomation");
		
		driver.close();
		driver.quit();
	}

}
