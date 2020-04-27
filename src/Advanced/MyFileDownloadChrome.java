package Advanced;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MyFileDownloadChrome {

	@Test
	public void myDownload() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\64\\chromedriver_win32_B39\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", "E:\\64\\TestB21");
	       ChromeOptions options = new ChromeOptions();
	       HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
	       options.setExperimentalOption("prefs", chromePrefs);
	       options.addArguments("--test-type");
	       options.addArguments("--disable-extensions"); //to disable browser extension popup
	  
	       DesiredCapabilities cap = DesiredCapabilities.chrome();
	       cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
	       cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	       cap.setCapability(ChromeOptions.CAPABILITY, options);
	       WebDriver driver = new ChromeDriver(options);  
		
		  driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
	         
		  driver.findElement(By.xpath("//div/div/a[contains(text(),'Download PDF File')]")).click();//Download Text File
		  Thread.sleep(15000);
		    
		  driver.quit();
	}
	

}
