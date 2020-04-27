package Advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MyImplicitExplicitWait {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait obj = new WebDriverWait(driver, 10);
		WebElement myElement = obj.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='SearchXXX']")));
		myElement.sendKeys("Subhasish");
		System.out.println("Script running");

	}
}
