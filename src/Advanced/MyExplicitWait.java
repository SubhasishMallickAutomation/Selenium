package Advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


//An Explicit waits is code you define to wait for a certain condition to
//occur before proceeding  further in the code.

public class MyExplicitWait {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		WebDriverWait obj = new WebDriverWait(driver, 25);
		WebElement myElement = obj.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='SearchXXX']")));
		myElement.click();

	}
}
