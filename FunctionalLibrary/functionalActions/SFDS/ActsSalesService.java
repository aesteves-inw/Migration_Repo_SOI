package functionalActions.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import sfDirectSales.SalesForceService;

public class ActsSalesService {
	
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 *		String actionName = "";
			
			
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

	public static void goToServiceDetails(WebDriver driver, WebDriverWait wait, int stepID) throws Exception
	{
		String actionName = "goToServiceDetails - Service: Go To Service Details Page";
		
		
		
		try
		{
			
			BrowserActions.jsClick(driver, By.xpath(SalesForceService.tabDetails));
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			
			System.out.println(actionName+" - Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}
	
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
	
	
	public static boolean validationServicePage(WebDriver driver, int stepID) throws Exception
	{
	 	String actionName="Service: Service screen Validation";
	 	try
		{
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
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

}







