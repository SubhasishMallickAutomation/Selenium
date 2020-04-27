package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MyDemoFormScript {

	@Test
	public void DemoForm() {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		
		//text box
		driver.findElement(By.xpath("//div/input[@placeholder='First Name']")).sendKeys("Subhasish");
		driver.findElement(By.xpath("//div/input[@placeholder='Last Name']")).sendKeys("Mallick");
		driver.findElement(By.xpath("//div/textarea[@ng-model='Adress']")).sendKeys("Hinjewadi, Pune");
		driver.findElement(By.xpath("//div/input[@ng-model='EmailAdress']")).sendKeys("subhasishapc@gmail.com");
		driver.findElement(By.xpath("//div/input[@ng-model='Phone']")).sendKeys("9038992765");
		
		//Radio button
		driver.findElement(By.xpath("//div/label/input[@value='Male']")).click();
		
		//Check box
		driver.findElement(By.xpath("//div/div/input[@value='Cricket']")).click();
		driver.findElement(By.xpath("//div/div/input[@value='Hockey']")).click();
		
		
		//1 dropdown
		//driver.findElement(By.xpath("//div/select[@id='Skills']")).click();
		//driver.findElement(By.xpath("//div/select[@id='Skills']/option[contains (text(),'XML')]")).click();
		
		//2 dropdown
		//driver.findElement(By.xpath("//div/select[@id='Skills']/option[contains (text(),'XML')]")).click();
		
		//3 dropdown
		WebElement skill = driver.findElement(By.xpath("//div/select[@id='Skills']"));
		Select skills = new Select(skill);
		skills.selectByVisibleText("XML");
		//skills.selectByIndex(1);
		//skills.selectByValue("Android");
		
		driver.findElement(By.xpath("//div/input[@id='firstpassword']")).sendKeys("1");
		
		driver.findElement(By.xpath("//div/input[@id='secondpassword']")).sendKeys("1");
		
	}
}
