package orderEnrichmentDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesOrderEnrichment;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class OrderEnrichmentAction 
{
	// Operational Actions

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

	public static void selectProductForOEConfig(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="selectProductForOEConfig";


		try
		{
			if(productName == "Enterprise Voice") {driver.findElement(By.xpath("//*[starts-with(text(),'"+productName+"')]")).click();}
			
			else if (productName == "Professional Internet") {driver.findElement(By.xpath("//*[starts-with(text(),'"+productName+"')]")).click();} 
			
			else {driver.findElement(By.xpath("//div[text()='"+productName+"']")).click();}
			
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"specificationsApp\"]/div[2]/div[2]/article/div[2]/iframe")));
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(DirSalesOrderEnrichment.tabsList)));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}




	// Validation Actions
	public static boolean tabsforOEValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="tabsforOEValidation";

		int errorCounter=0;

		try
		{
			
			List<WebElement> oeTabsList=driver.findElements(By.xpath(DirSalesOrderEnrichment.tabInTheList));

			for(WebElement oetab:oeTabsList)
			{
				//if (oetab.getText().toLowerCase().contains("contact"))
				if (oetab.isDisplayed())
				{
					System.out.println(oetab.getText());
					errorCounter++;
				}
			}

			if(errorCounter > 0)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

}
