package executionTools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestObjectTools {

	public static String getDataRecordID(WebDriver driver, String objectName)
	{
		String dataRecordID;

		dataRecordID=driver.findElement(By.linkText(objectName)).getAttribute("data-recordid");

		return dataRecordID;

	}

}
