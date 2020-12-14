package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import objectMap.sfDirectSales.DirSalesProductBasket;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProductBasketAction {
	
	//Operational Actions
	
	public static void changeToProductBasketiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		String actionName="Product Basket: Change to Product Basket iframe";

		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesProductBasket.iframeProductBasket)));

			WebElement iframeProductBasket = driver.findElement(By.xpath(DirSalesProductBasket.iframeProductBasket));

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
	
	public static boolean productBasketScreenValidation(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Validation of Product Basket Screen";

		try
		{			
			changeToProductBasketiFrame(logStream, driver, stepID);

			if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.cloneBasketButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.syncButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketHeader) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.productBasketName) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.addProductButton) && 
					BrowserActions.isElementPresent(driver, DirSalesProductBasket.opportunityName))
			{
				System.out.println(actionName+" - Succeeded in Step: "+stepID);


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

			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}

}
