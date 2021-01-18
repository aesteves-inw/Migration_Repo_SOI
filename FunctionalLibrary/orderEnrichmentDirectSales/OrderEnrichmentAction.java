package orderEnrichmentDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectMap.sfDirectSales.DirSalesOrderEnrichment;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderEnrichmentAction 
{
	public static void changeToOrderEnrichmentiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);

		String actionName="Product Basket: Change to Product Basket iframe";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesOrderEnrichment.iframeOrderEnrichment)));

			WebElement iframeOrderEnrichment = driver.findElement(By.xpath(DirSalesOrderEnrichment.iframeOrderEnrichment));

			driver.switchTo().frame(iframeOrderEnrichment);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOrderEnrichment.headerOrderEnrichment)));

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
