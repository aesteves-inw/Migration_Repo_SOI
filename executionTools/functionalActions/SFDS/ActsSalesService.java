package functionalActions.SFDS;

import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import sfDirectSales.SalesForceService;

public class ActsSalesService {
	
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







