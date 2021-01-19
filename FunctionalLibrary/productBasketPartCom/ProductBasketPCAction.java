package productBasketPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesProductBasket;
import objectMap.sfPartnersCommunity.PartComProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketPCAction 
{
	// Operational Actions
	public static void changeToProductBasketiframePC(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver,30);

		String actionName="Product Basket: Change to Product Basket iframe in Partners Community";


		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PartComProductBasket.iframeProductBasket)));

			WebElement iframeProductBasket = driver.findElement(By.xpath(PartComProductBasket.iframeProductBasket));

			driver.switchTo().frame(iframeProductBasket);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesProductBasket.productBasketLabel)));

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
	public static boolean validateProductBasketScreen(List<TestLog> logStream, int stepID, WebDriver driver) throws Exception 
	{
		String actionName="Product Basket: Validation of Product Basket Screen";

		try
		{			
			changeToProductBasketiframePC(logStream, stepID, driver);

			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.opportunityName))
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

