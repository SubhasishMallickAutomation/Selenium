package Advanced;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTableGrid {

		@Test
		public void fd() {
			System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://money.rediff.com/mutual-funds/liquid");
			
			
			MyTableUtil table = new MyTableUtil();
			String v1 =table.getTableCellValue(driver, "Company", "Returns(%)", "Tata Asset Management Ltd.");
			Assert.assertEquals(v1, "8.13");
			
			String v2 =table.getTableCellValue(driver, "Company", "Returns(%)", "SBI Funds Management Pvt. Ltd.");
			Assert.assertEquals(v2, "8.07");
			
			String v3 =table.getTableCellValue(driver, "Company", "Type", "Tata Asset Management Ltd.");
			Assert.assertEquals(v3, "Open Ended");
		}
}
