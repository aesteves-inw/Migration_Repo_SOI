package orderDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderNavigation {

	public static void goToServiceScreenByServiceName(List<TestLog> logStream, WebDriver driver, int stepID,
			String serviceName) throws Exception 
	{
		String actionName="goToServiceScreenByServiceName";


		try
		{
//			String serviceURL=driver.findElement(By.xpath("//a[starts-with(text(),'"+serviceName+"')]")).getAttribute("href");
			// Xpath syntax simulates ends-with and starts-with functions
			String serviceURL=driver.findElement(By.xpath("//a[text()[substring(.,string-length(.) - string-length('"+serviceName+"') + 1) = '"+serviceName+"'] and starts-with(text(),'"+serviceName+"')]")).getAttribute("href");
			
			System.out.println("Debug - serviceURL: "+serviceURL);
			
			BrowserActions.goToByURL(driver, serviceURL);
			
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

}
