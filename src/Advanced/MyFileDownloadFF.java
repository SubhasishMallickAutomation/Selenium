package Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MyFileDownloadFF {
	@Test
	public void myDownload() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "E:\\64\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		
		 FirefoxProfile fprofile = new FirefoxProfile();//Create object of FirefoxProfile  to access Its properties.
		  fprofile.setPreference("browser.download.dir", "E:\\64\\TestB21");//Set Location to store files after downloading.
		  fprofile.setPreference("browser.download.folderList", 2);//Set Preference to not show file download confirmation dialogue using  types Of different file extension types.
		  
		  fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//types Of MS Excel File.
		    + "application/pdf;" //types Of PDF File.
		    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //types Of MS doc File.
		    + "text/plain;" //types Of text File.
		    + "text/csv"); //types Of CSV File.
		  fprofile.setPreference( "browser.download.manager.showWhenStarting", false );
		  fprofile.setPreference( "pdfjs.disabled", true );
		  
		  cap.setCapability(FirefoxDriver.PROFILE, fprofile);
		  //cap.setCapability("marionette", true);
		  FirefoxOptions op = new FirefoxOptions(cap);
		  WebDriver driver = new FirefoxDriver(op);  //Pass fprofile parameter In webdriver to use preferences to download file.
		  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
	         
		  driver.findElement(By.xpath("//a[contains(text(),'Download Text File')]")).click();//Download Text File
		  Thread.sleep(15000);
		    
		  //driver.quit();
	}
	
}
