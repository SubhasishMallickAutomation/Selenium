package DataDriven;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDemoFormDataDriven {
	WebDriver driver ;
	String excelPath=
			"C:\\Users\\lenovo\\workspace111\\RadicalSelenium\\src\\DataDriven\\MyFormDemoDD.xlsx";

	@Test(dataProvider="MyDataProvider")
	public void dataForm(String fName, String lName, String address, String email) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div/input[@placeholder='First Name']")).sendKeys(fName);
		driver.findElement(By.xpath("//div/input[@placeholder='Last Name']")).sendKeys(lName);
		driver.findElement(By.xpath("//div/textarea[@ng-model='Adress']")).sendKeys(address);
		driver.findElement(By.xpath("//div/input[@ng-model='EmailAdress']")).sendKeys(email);

	}

	@DataProvider(name="MyDataProvider")
	public Object[][] getData() throws InvalidFormatException, IOException{
		ReadExcelSheet excelObj = new ReadExcelSheet(excelPath);
		int rowCount = excelObj.getRowCount(0);
		int columnCount = excelObj.getColumnCount(0);
		Object[][] data = new Object[rowCount][columnCount];
		for(int i=0;i<rowCount;i++ ){
			for(int j=0;j<columnCount;j++ ){

				data[i][j]=excelObj.getCellData(0,i, j);
			}
		}
		return data;
	}


	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
}
