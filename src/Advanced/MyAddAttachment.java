package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyAddAttachment {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freefileconvert.com/");

		driver.findElement(By.xpath("//div/input[@id='first_file']")).sendKeys("E:\\64\\Links_b21.txt");

	}
}
