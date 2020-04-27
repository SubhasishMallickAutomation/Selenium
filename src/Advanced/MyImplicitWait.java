package Advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//An implicit wait is to tell webdriver to poll in the DOM for a
//certain amount of time when 
//trying to find an element
//or elements if they are not immediately available.
//The default sorting is 0. Once set, the implicit wait is set for the 
//life of the webdriver object instance.


public class MyImplicitWait {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@title='SearchXXX']")).sendKeys("abc");
		System.out.println("Script running");

	}
}
