package Advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTableUtil {
	
	public String  getTableCellValue(WebDriver driver,String firstColName,String secondColName,String firstColValue){
		List<WebElement> tableCols = driver.findElements(By.xpath("//table/thead/tr/th"));
		int totalColsCount = tableCols.size();
		int companyColPosition = 0;
		
		for(int i = 1 ; i <= totalColsCount ; i++){
			String colName =  driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText();
			if(colName.equals(firstColName)){
				companyColPosition = i;
				break;
			}
		}
		int returnColPosition = 0;
		
		for(int i = 1 ; i <= totalColsCount ; i++){
			String colName =  driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText();
			if(colName.equals(secondColName)){
				returnColPosition = i;
				break;
			}
		}
		
		List<WebElement> tableRos =driver.findElements(By.xpath("//table/tbody/tr"));
		int totalRows = tableRos.size();
		int rowPosition = 0;
		for(int i =1; i<=totalRows; i++ ){
			String rowValue = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+companyColPosition+"]")).getText();
			if(rowValue.equals(firstColValue)){
				rowPosition = i;
				break;
			}
		}
		String actualValue = driver.findElement(By.xpath("//table/tbody/tr["+rowPosition+"]/td["+returnColPosition+"]")).getText();
		return actualValue;
	}

}
