package productBasketDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	public static void changeToDefaultiFrame(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Change to default frame";


		try
		{
			driver.switchTo().defaultContent();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
		}
	}

	public static void openAddProductMenu(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception
	{
		String actionName="Product Basket: Open Add Product Menu";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.addProductButton)).click();

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void syncProductBasket(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{
		String actionName="syncProductBasket";


		try
		{
			driver.findElement(By.xpath(DirSalesProductBasket.syncButton)).click();
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
		}
		
	}
	
	public static void selectLineItem(List<TestLog> logStream, WebDriver driver, int newStepCounter, String productName) throws Exception 
	{
		String actionName="selectLineItem";


		try
		{
			WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));
			
			List<WebElement> productBasketLineItem=productBasketTable.findElements(By.tagName("li"));
			
			for(WebElement we : productBasketLineItem)
			{
				if(we.getText().contains(productName))
				{
					we.findElement(By.xpath(DirSalesProductBasket.selectLineItemCheckBox)).click();
					break;
				}
			}			
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
		}
		
	}

	public static void deleteLineItem(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{
		String actionName="deleteLineItem";


		try
		{
			WebElement deleteButton = new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Delete Product']")));
			
			deleteButton.click();
			
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text()='Delete Product']")));
			
			driver.findElement(By.xpath("//span[@ng-bind='::LabelsConstant.DELETE_PRODUCTS_CONFIRMATION_DIALOG.BTN_OK']")).click();
			
			Thread.sleep(5000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+newStepCounter);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
			throw new Exception (actionName+" - Failed in Step "+newStepCounter,e);
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

	
	public static boolean productOnProductBasketValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="productOnProductBasketValidation";
		 
		 try
			{
			 	WebElement productBasketTable=driver.findElement(By.xpath(DirSalesProductBasket.productBasketTable));
			 	
			 	String productBasketLineItemValidation=productBasketTable.getText().toString();
			 
				if(productBasketLineItemValidation.contains(productName))
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
	
	public static boolean productOnProductBasketNegativeValidation(List<TestLog> logStream, WebDriver driver, int stepID,
			String productName) throws Exception 
	{
		String actionName="productOnProductBasketNegativeValidation";
		 
		 try
			{		 
				if(BrowserActions.isElementPresent(driver, "//ul/li[text()='"+productName+"']")==false)
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

	
	public static boolean syncProductBasketNegVal(List<TestLog> logStream, WebDriver driver, int newStepCounter) throws Exception 
	{
		
		 String actionName="syncProductBasketNegVal";
		 
	     	try
					{
						if(BrowserActions.isElementPresent(driver, DirSalesProductBasket.errorMessagePB))
						{
							TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+newStepCounter);
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
						TestLogger.logError(logStream, actionName, "Failed in Step "+newStepCounter, e.toString());
						throw new Exception (actionName+" - Failed in Step: "+newStepCounter,e);
					}
	}

	
	
	

	
	


}
