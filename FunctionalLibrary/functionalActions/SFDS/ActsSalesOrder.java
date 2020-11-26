package functionalActions.SFDS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.*;
import execStructure.TestDataManagement;
import executionTools.BrowserActions;
import sfDirectSales.SalesForceOrders;

public class ActsSalesOrder {
	/*
	 String actionName="";


		try
		{
			<JAVA CODE>

			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	*/
	
	// NAVIGATION ACTIONS
	public static void navigateToSingleService(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="navigateToService: Order - Navigate to Service Screen";
		
		
		try
		{
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SalesForceOrders.serviceContainer)));
			
			System.out.println("Debug de SalesForceOrders.serviceContainer: "+BrowserActions.isElementPresent(driver, SalesForceOrders.serviceContainer));
			
			WebElement servicesContainer = driver.findElement(By.xpath(SalesForceOrders.serviceContainer));
			
			List<WebElement> serviceLinks = servicesContainer.findElements(By.tagName("a"));
			
			for(WebElement we:serviceLinks)
			{
				System.out.println("Debug: "+we.getAttribute("href"));
				
				if(we.getAttribute("href").contains("csord__Service__c"))
				{
					driver.get(we.getAttribute("href"));
					break;
				}
			}
			
			
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	
	
	//ORDER PAGE	
	public static void addServiceToOrder(WebDriver driver, int stepID) throws Exception
	{
		 String actionName="Order: Add Service (First Screen)";


			try
			{
				driver.findElement(By.xpath(SalesForceOrders.addServiceButton)).click();
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				

				System.out.println(actionName+" - Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
	}
	
	//ORDER LIST VIEW // SOI-80

	public static void nav2OrdersListView(WebDriver driver, int stepID) throws Exception
	{
		String actionName = "Navigation to Orders List View";
		
		String ordersListViewURL=TestDataManagement.searchDT(0, "environmentITTQA").concat(TestDataManagement.searchDT(0, "ordersList"));
		
		try
		{
			driver.get(ordersListViewURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
	public static void changeOrdersListFilter(WebDriver driver, WebDriverWait wait, int stepID, String filter) throws Exception
	{
		String actionName = "Change Order List Filter";
		
		try
		{
			driver.findElement(By.xpath(SalesForceOrders.selectFilterListViewBtn)).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(.,'"+filter+"')]"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/th")));
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void searchOrdersList(WebDriver driver, WebDriverWait wait, int stepID, String inputSearchValue) throws Exception
	{
		String actionName = "Search value: "+inputSearchValue+" - in Orders List search input";
		
		WebDriverWait searchOrdersListW=new WebDriverWait(driver, 20);
		
		try
		{
			driver.findElement(By.xpath(SalesForceOrders.inputSearchBar)).clear();
			
			driver.findElement(By.xpath(SalesForceOrders.inputSearchBar)).sendKeys(inputSearchValue);
			
			driver.findElement(By.xpath(SalesForceOrders.inputSearchBar)).sendKeys(Keys.ENTER);
			
			searchOrdersListW.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SalesForceOrders.ordersTable), inputSearchValue));
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	public static void navigate2FirstOrder(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName = "Navigate to first Order in List";
		try
		{
			driver.findElement(By.xpath(SalesForceOrders.firstOrderNameLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			System.out.println(actionName+" - Succeeded in Step: "+stepID);
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
	
	
	//VALIDATIONS
	
	/*02-03-2020:LMA
	 * sketch for every validation functions
	 *=====================================
	 	String actionName="";
	 	
	 	boolean validationValue;
	 	
	 	try
		{
			if()
			{
				
				validationValue = true;
			}
			else
			{
				validationValue = false;
			}
			
			System.out.println(actionName+" - Succeeded in Step: "+stepID);
			
			return validationValue;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
			
			*/
	
	
	public static boolean orderPageValidation(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Order Page Validation";
				
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.orderTypeLabel) && BrowserActions.isElementPresent(driver, SalesForceOrders.servicesContainer) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderDetails) && BrowserActions.isElementPresent(driver, SalesForceOrders.orderHeader))
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
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
	
	public static boolean orderListViewPageValidation(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName="Order List View Page - Validation";
		
		try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.selectFilterListViewBtn) && BrowserActions.isElementPresent(driver, SalesForceOrders.inputSearchBar) && BrowserActions.isElementPresent(driver, SalesForceOrders.ordersTable) && BrowserActions.isElementPresent(driver, SalesForceOrders.listViewControlsBtn))
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
			System.out.println(actionName+" - Failed in Step: "+stepID);
			return false;
		}
	}
	
	public static boolean addServiceToOrderValidation1stScreen(WebDriver driver, int stepID) throws Exception
	{
		String actionName="Order: Add Service First Screen Validation";
		
		boolean validationValue;
		
	 	try
		{
	 		
			if(
					BrowserActions.isElementPresent(driver, SalesForceOrders.addServiceHeader) &&
					BrowserActions.isElementPresent(driver, SalesForceOrders.inputDomain) && 
					BrowserActions.isElementPresent(driver, SalesForceOrders.inputType) && 
					BrowserActions.isElementPresent(driver, SalesForceOrders.inputDetail) &&
					BrowserActions.isElementPresent(driver, SalesForceOrders.nextButton)
					)
			{
				validationValue = true;
			}
			else
			{
				validationValue = false;
			}
			
			
			System.out.println(actionName+" - Succeeded in Step: "+stepID);
			
			return validationValue;
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
	
	public static boolean serviceValidationOnOrderPage(WebDriver driver, int stepID) throws Exception
	{
	 	String actionName="Order: Service validation on Order's Page";
	 	
	 	boolean validationValue;
	 	
	 	try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceOrders.serviceMobileLink))
			{
				
				validationValue = true;
			}
			else
			{
				validationValue = false;
			}
			
			System.out.println(actionName+" - Succeeded in Step: "+stepID);
			
			return validationValue;
			
		}
		catch(Exception e)
		{
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}
}







