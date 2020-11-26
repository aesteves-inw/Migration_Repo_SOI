package functionalActions.SFPC;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import sfPartnersCommunity.SFPC_Services;

public class ActsPartsService {
	
	
	/*02-03-2020:LMA
	 * sketch for every regular functions
	 *=====================================
	 	String actionName = "";
			
			
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
	
	
	public static boolean serviceScreenValidation(WebDriver driver, int stepID) throws Exception
	{
	 	String actionName="Service: Service Screen validation";
	 	try
		{
			if(BrowserActions.isElementPresent(driver, SFPC_Services.filesContainer) && 
					BrowserActions.isElementPresent(driver, SFPC_Services.headerServicesPage) && 
					BrowserActions.isElementPresent(driver, SFPC_Services.detailsServicePage))
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
