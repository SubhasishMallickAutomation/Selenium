package DataDriven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MyDataDrivenScript {
	
	WebDriver driver ;
	String excelPath=
			"E:\\64\\loginDemo.xlsx";
	
	@Test(dataProvider="B7MyDataProvider")
	public void loginToFacebook(String username, String password) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	@DataProvider(name="B7MyDataProvider")
	public Object[][] getDataB7() throws InvalidFormatException, IOException{
		ReadExcelSheet excelObj = new ReadExcelSheet(excelPath);
		int rowCount = excelObj.getRowCount(0);
		Object[][] data = new Object[rowCount][2];
		for(int i=0;i<rowCount;i++ ){
			data[i][0]=excelObj.getCellData(0,i, 0);
			data[i][1]=excelObj.getCellData(0,i, 1);
		}
		return data;
	}
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
