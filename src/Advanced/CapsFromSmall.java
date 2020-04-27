package Advanced;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CapsFromSmall {

	@Test
	public void fd() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		WebElement name = driver.findElement(By.xpath("//tr/td/input[@name='email']"));

		Actions myAction = new Actions(driver);
		//Option 1 - does not work on firefox
		Actions obj = myAction.moveToElement(name).click().keyDown(Keys.SHIFT).sendKeys("subhasish");
		
		obj.build().perform();
		
		//Option 2 - cannot be used with right click action.
		//driver.findElement(By.xpath("//tr/td/input[@name='email']")).sendKeys(Keys.SHIFT,"mallick");
	}
}
