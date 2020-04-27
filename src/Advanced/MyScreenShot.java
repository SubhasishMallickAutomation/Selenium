package Advanced;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyScreenShot {

	@Test
	public void mygoogleScenario() throws InterruptedException, IOException{
		WebDriver driver = null;
		try{
			System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://google.com");
			driver.findElement(By.xpath("//input[@title='SearchXX']")).sendKeys("selenium");
		}catch(Exception e){
			TakesScreenshot a = (TakesScreenshot) driver;
			File srcFile= a.getScreenshotAs(OutputType.FILE);
			String myTimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
					.format(Calendar.getInstance().getTime());
			String title = driver.getTitle();
			FileUtils.copyFile(srcFile, new File("E:\\test21_1\\B21googleError1_"+title+""+myTimeStamp+".png"));
		}
		
		
		//B15ScreenshotUtil.takeScreenshot(driver);
//		
//		boolean result = true;
//		try{
//			driver.get("http://www.google.com");
//			Thread.sleep(6000);
//			driver.findElement(By.xpath("//input[@id='lst-ib1xxx']"));
//		}catch(Exception e){
//			B15ScreenshotUtil.takeScreenshot(driver);
//			result =false;
//			System.out.println("taking screen shot");
//		}
//		driver.close();
//		driver.quit();
//		Assert.assertTrue(result);
//		
		
//		File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(srcFile, new File("C:\\testb16\\googleErrorB17.png"));
//		driver.close();
//		Thread.sleep(3000);
		
//		String myTimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
//				.format(Calendar.getInstance().getTime());
//		
//		TakesScreenshot a = (TakesScreenshot) driver;
//		File srcFile= a.getScreenshotAs(OutputType.FILE);
//		String title = driver.getTitle();
//		FileUtils.copyFile(srcFile, new File("C:\\test\\B16googleError_"+title+myTimeStamp+".png"));
		
		
	}
}
