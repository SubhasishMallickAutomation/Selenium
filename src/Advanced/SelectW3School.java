package Advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectW3School {

	@Test
	public void window() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");

		driver.switchTo().frame("iframeResult");
		WebElement car = driver.findElement(By.xpath("//body/form/select[@name='cars']"));
		Select cars = new Select(car);
		
		cars.selectByValue("volvo");
		cars.selectByVisibleText("Audi");
		cars.selectByIndex(2);
		//cars.getAllSelectedOptions();
				
		driver.findElement(By.xpath("//body/form/input[@type='submit']")).click();

		String msg = driver.findElement(By.xpath("//body/div[@class='w3-container w3-large w3-border']")).getText();
		System.out.println("Your input was received as: "+msg);

		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();

	}
}
