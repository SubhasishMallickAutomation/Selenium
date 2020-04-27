package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {

	@Test
	public void Click() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.dev/");
		WebElement project = driver.findElement(By.xpath("//nav/a[contains(text(),'Projects')]"));
		Actions act1 = new Actions(driver);
		act1.contextClick(project).perform();
		
	}
}
