package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execStructure.TestData;
import sfDirectSales.SalesForceOrders;

public class Order {
	
	//ORDER PAGE
	
	//ORDER LIST VIEW
	public static void nav2OrdersListView(WebDriver driver, int stepID) throws Exception
	{
		String actionName = "Navigation to Orders List View";
		
		String ordersListViewURL=TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));
		
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
	
	
	
}

/*02-03-2020:LMA
 * sketch for every regular functions
 *=====================================
 *		String actionName = "Navigation to Orders List View";
		
		String ordersListViewURL=TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "ordersList"));
		
		try
		{
			<JAVA CODE>
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
		*/


/*02-03-2020:LMA
 * sketch for every validation functions
 *=====================================
 	String actionName="";
 	try
	{
		if()
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
		
		*/


