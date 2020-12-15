package addOfferToBasketDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesAddOfferToBasket;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AddOfferToBasketAction {
	
	//Operational Actions
	
	public static void pickProductOnAddOfferBasket(List<TestLog> logStream, WebDriver driver, int stepID, String productToAdd) throws Exception
	 {
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		 String actionName="Add Offer to Basket: Pick Product - "+productToAdd;
	
	
			try
			{
				driver.findElement(By.linkText(productToAdd)).click();
				
				WebElement productSummary=driver.findElement(By.xpath(DirSalesAddOfferToBasket.summarySection));
				
				String productVal=productSummary.getText().toString();
				
				if(productVal.contains(productToAdd))
				{
					driver.findElement(By.xpath(DirSalesAddOfferToBasket.add2OfferButton)).click();
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.singleLineItemProduct)));
					
				}
				else
				{
					throw new Exception ("Not Possible to confirm Product Selection on Step "+stepID);
				}
	
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
	
			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
		}
	
	//Validation Actions
	
	public static boolean addProductMenuValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="addProductMenuValidation";
		
		try
		{
			if(BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.offerNameHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.offerList) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.add2OfferCancelButton) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.add2OfferButton) && 
					//BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.summarySection) && 
					BrowserActions.isElementPresent(driver, DirSalesAddOfferToBasket.productCatalog))
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
