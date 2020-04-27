package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAlert_Confirmation1 {

	@Test
	public void alert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");

		//driver.findElement(By.xpath("//div/button[@onclick='alertbox()']")).click();
		driver.findElement(By.xpath("//div/div/button[contains(text(),'click the button to display an  alert box:')]")).click();
		Thread.sleep(1000);

		Alert myAlertobj = driver.switchTo().alert();
		String alertMsg = myAlertobj.getText();
		myAlertobj.accept();

		driver.findElement(By.xpath("//div/ul/li/a[contains(text(),'Alert with OK & Cancel')]")).click();
		driver.findElement(By.xpath("//div/button[contains(text(),'click the button to display a confirm box')]")).click();
		Thread.sleep(1000);
		Alert myAlertobj1 = driver.switchTo().alert();
		String alertMsg1 = myAlertobj.getText();
		myAlertobj1.dismiss();
		
		//Alert Validation
		Assert.assertEquals(alertMsg, "I am an alert box!");
		//Confirmation Validation
		Assert.assertEquals(alertMsg1, "Press a Button !");

		String msg = driver.findElement(By.xpath("//div/p[@id='demo']")).getText();

		System.out.println(msg);


	}
}
